<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="商品ID" prop="productId">
        <el-input
          v-model="queryParams.productId"
          placeholder="请输入商品ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="规格ID" prop="specId">
        <el-input
          v-model="queryParams.specId"
          placeholder="请输入规格ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="库存数量" prop="stockQuantity">
        <el-input
          v-model="queryParams.stockQuantity"
          placeholder="请输入库存数量"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="冻结数量" prop="freezeQuantity">
        <el-input
          v-model="queryParams.freezeQuantity"
          placeholder="请输入冻结数量"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="累计入库" prop="totalIn">
        <el-input
          v-model="queryParams.totalIn"
          placeholder="请输入累计入库"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="累计出库" prop="totalOut">
        <el-input
          v-model="queryParams.totalOut"
          placeholder="请输入累计出库"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="库存预警值" prop="warningStock">
        <el-input
          v-model="queryParams.warningStock"
          placeholder="请输入库存预警值"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="最后入库时间" prop="lastInTime">
        <el-date-picker clearable
          v-model="queryParams.lastInTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择最后入库时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="最后出库时间" prop="lastOutTime">
        <el-date-picker clearable
          v-model="queryParams.lastOutTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择最后出库时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['shop:stock:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['shop:stock:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['shop:stock:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['shop:stock:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="stockList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="库存ID" align="center" prop="stockId" />
      <el-table-column label="商品ID" align="center" prop="productId" />
      <el-table-column label="规格ID" align="center" prop="specId" />
      <el-table-column label="库存数量" align="center" prop="stockQuantity" />
      <el-table-column label="冻结数量" align="center" prop="freezeQuantity" />
      <el-table-column label="累计入库" align="center" prop="totalIn" />
      <el-table-column label="累计出库" align="center" prop="totalOut" />
      <el-table-column label="库存预警值" align="center" prop="warningStock" />
      <el-table-column label="最后入库时间" align="center" prop="lastInTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.lastInTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="最后出库时间" align="center" prop="lastOutTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.lastOutTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['shop:stock:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['shop:stock:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改库存信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="商品ID" prop="productId">
          <el-input v-model="form.productId" placeholder="请输入商品ID" />
        </el-form-item>
        <el-form-item label="规格ID" prop="specId">
          <el-input v-model="form.specId" placeholder="请输入规格ID" />
        </el-form-item>
        <el-form-item label="库存数量" prop="stockQuantity">
          <el-input v-model="form.stockQuantity" placeholder="请输入库存数量" />
        </el-form-item>
        <el-form-item label="冻结数量" prop="freezeQuantity">
          <el-input v-model="form.freezeQuantity" placeholder="请输入冻结数量" />
        </el-form-item>
        <el-form-item label="累计入库" prop="totalIn">
          <el-input v-model="form.totalIn" placeholder="请输入累计入库" />
        </el-form-item>
        <el-form-item label="累计出库" prop="totalOut">
          <el-input v-model="form.totalOut" placeholder="请输入累计出库" />
        </el-form-item>
        <el-form-item label="库存预警值" prop="warningStock">
          <el-input v-model="form.warningStock" placeholder="请输入库存预警值" />
        </el-form-item>
        <el-form-item label="最后入库时间" prop="lastInTime">
          <el-date-picker clearable
            v-model="form.lastInTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择最后入库时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="最后出库时间" prop="lastOutTime">
          <el-date-picker clearable
            v-model="form.lastOutTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择最后出库时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" type="textarea" placeholder="请输入内容" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listStock, getStock, delStock, addStock, updateStock } from "@/api/shop/stock"

export default {
  name: "Stock",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 库存信息表格数据
      stockList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        productId: null,
        specId: null,
        stockQuantity: null,
        freezeQuantity: null,
        totalIn: null,
        totalOut: null,
        warningStock: null,
        lastInTime: null,
        lastOutTime: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        productId: [
          { required: true, message: "商品ID不能为空", trigger: "blur" }
        ],
      }
    }
  },
  created() {
    this.getList()
  },
  methods: {
    /** 查询库存信息列表 */
    getList() {
      this.loading = true
      listStock(this.queryParams).then(response => {
        this.stockList = response.rows
        this.total = response.total
        this.loading = false
      })
    },
    // 取消按钮
    cancel() {
      this.open = false
      this.reset()
    },
    // 表单重置
    reset() {
      this.form = {
        stockId: null,
        productId: null,
        specId: null,
        stockQuantity: null,
        freezeQuantity: null,
        totalIn: null,
        totalOut: null,
        warningStock: null,
        lastInTime: null,
        lastOutTime: null,
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null,
        remark: null
      }
      this.resetForm("form")
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1
      this.getList()
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm")
      this.handleQuery()
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.stockId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset()
      this.open = true
      this.title = "添加库存信息"
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset()
      const stockId = row.stockId || this.ids
      getStock(stockId).then(response => {
        this.form = response.data
        this.open = true
        this.title = "修改库存信息"
      })
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.stockId != null) {
            updateStock(this.form).then(response => {
              this.$modal.msgSuccess("修改成功")
              this.open = false
              this.getList()
            })
          } else {
            addStock(this.form).then(response => {
              this.$modal.msgSuccess("新增成功")
              this.open = false
              this.getList()
            })
          }
        }
      })
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const stockIds = row.stockId || this.ids
      this.$modal.confirm('是否确认删除库存信息编号为"' + stockIds + '"的数据项？').then(function() {
        return delStock(stockIds)
      }).then(() => {
        this.getList()
        this.$modal.msgSuccess("删除成功")
      }).catch(() => {})
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('shop/stock/export', {
        ...this.queryParams
      }, `stock_${new Date().getTime()}.xlsx`)
    }
  }
}
</script>

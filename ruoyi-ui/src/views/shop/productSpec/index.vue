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
      <el-form-item label="规格名称" prop="specName">
        <el-input
          v-model="queryParams.specName"
          placeholder="请输入规格名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="规格编码" prop="specCode">
        <el-input
          v-model="queryParams.specCode"
          placeholder="请输入规格编码"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="进货价" prop="priceIn">
        <el-input
          v-model="queryParams.priceIn"
          placeholder="请输入进货价"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="销售价" prop="priceSale">
        <el-input
          v-model="queryParams.priceSale"
          placeholder="请输入销售价"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="会员价" prop="priceVip">
        <el-input
          v-model="queryParams.priceVip"
          placeholder="请输入会员价"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="库存数量" prop="stock">
        <el-input
          v-model="queryParams.stock"
          placeholder="请输入库存数量"
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
      <el-form-item label="规格条码" prop="barcode">
        <el-input
          v-model="queryParams.barcode"
          placeholder="请输入规格条码"
          clearable
          @keyup.enter.native="handleQuery"
        />
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
          v-hasPermi="['shop:productSpec:add']"
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
          v-hasPermi="['shop:productSpec:edit']"
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
          v-hasPermi="['shop:productSpec:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['shop:productSpec:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="productSpecList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="规格ID" align="center" prop="specId" />
      <el-table-column label="商品ID" align="center" prop="productId" />
      <el-table-column label="规格名称" align="center" prop="specName" />
      <el-table-column label="规格编码" align="center" prop="specCode" />
      <el-table-column label="进货价" align="center" prop="priceIn" />
      <el-table-column label="销售价" align="center" prop="priceSale" />
      <el-table-column label="会员价" align="center" prop="priceVip" />
      <el-table-column label="库存数量" align="center" prop="stock" />
      <el-table-column label="库存预警值" align="center" prop="warningStock" />
      <el-table-column label="规格条码" align="center" prop="barcode" />
      <el-table-column label="状态" align="center" prop="status" />
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['shop:productSpec:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['shop:productSpec:remove']"
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

    <!-- 添加或修改商品规格对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="商品ID" prop="productId">
          <el-input v-model="form.productId" placeholder="请输入商品ID" />
        </el-form-item>
        <el-form-item label="规格名称" prop="specName">
          <el-input v-model="form.specName" placeholder="请输入规格名称" />
        </el-form-item>
        <el-form-item label="规格编码" prop="specCode">
          <el-input v-model="form.specCode" placeholder="请输入规格编码" />
        </el-form-item>
        <el-form-item label="进货价" prop="priceIn">
          <el-input v-model="form.priceIn" placeholder="请输入进货价" />
        </el-form-item>
        <el-form-item label="销售价" prop="priceSale">
          <el-input v-model="form.priceSale" placeholder="请输入销售价" />
        </el-form-item>
        <el-form-item label="会员价" prop="priceVip">
          <el-input v-model="form.priceVip" placeholder="请输入会员价" />
        </el-form-item>
        <el-form-item label="库存数量" prop="stock">
          <el-input v-model="form.stock" placeholder="请输入库存数量" />
        </el-form-item>
        <el-form-item label="库存预警值" prop="warningStock">
          <el-input v-model="form.warningStock" placeholder="请输入库存预警值" />
        </el-form-item>
        <el-form-item label="规格条码" prop="barcode">
          <el-input v-model="form.barcode" placeholder="请输入规格条码" />
        </el-form-item>
        <el-form-item label="删除标志" prop="delFlag">
          <el-input v-model="form.delFlag" placeholder="请输入删除标志" />
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
import { listProductSpec, getProductSpec, delProductSpec, addProductSpec, updateProductSpec } from "@/api/shop/productSpec"

export default {
  name: "ProductSpec",
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
      // 商品规格表格数据
      productSpecList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        productId: null,
        specName: null,
        specCode: null,
        priceIn: null,
        priceSale: null,
        priceVip: null,
        stock: null,
        warningStock: null,
        barcode: null,
        status: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        productId: [
          { required: true, message: "商品ID不能为空", trigger: "blur" }
        ],
        specName: [
          { required: true, message: "规格名称不能为空", trigger: "blur" }
        ],
      }
    }
  },
  created() {
    this.getList()
  },
  methods: {
    /** 查询商品规格列表 */
    getList() {
      this.loading = true
      listProductSpec(this.queryParams).then(response => {
        this.productSpecList = response.rows
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
        specId: null,
        productId: null,
        specName: null,
        specCode: null,
        priceIn: null,
        priceSale: null,
        priceVip: null,
        stock: null,
        warningStock: null,
        barcode: null,
        status: null,
        delFlag: null,
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
      this.ids = selection.map(item => item.specId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset()
      this.open = true
      this.title = "添加商品规格"
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset()
      const specId = row.specId || this.ids
      getProductSpec(specId).then(response => {
        this.form = response.data
        this.open = true
        this.title = "修改商品规格"
      })
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.specId != null) {
            updateProductSpec(this.form).then(response => {
              this.$modal.msgSuccess("修改成功")
              this.open = false
              this.getList()
            })
          } else {
            addProductSpec(this.form).then(response => {
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
      const specIds = row.specId || this.ids
      this.$modal.confirm('是否确认删除商品规格编号为"' + specIds + '"的数据项？').then(function() {
        return delProductSpec(specIds)
      }).then(() => {
        this.getList()
        this.$modal.msgSuccess("删除成功")
      }).catch(() => {})
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('shop/productSpec/export', {
        ...this.queryParams
      }, `productSpec_${new Date().getTime()}.xlsx`)
    }
  }
}
</script>

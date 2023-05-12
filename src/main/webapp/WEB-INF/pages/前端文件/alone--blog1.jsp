<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>题目具体信息</title>
  <style>
    .el-table .warning-row {
      background: oldlace;
    }

    .el-table .success-row {
      background: #f0f9eb;
    }
  </style>

</head>
<body>
<div id="app">

  <!--导航菜单栏-->
  <div class="line"></div>
  <el-menu
          :default-active="activeIndex2"
          class="el-menu-demo"
          mode="horizontal"
          @select="handleSelect"
          background-color="#545c64"
          text-color="#fff"
          active-text-color="#ffd04b">
    <el-menu-item  index="1"><a href="qqq-mainView.html">个人信息</a></el-menu-item>
  </el-menu>
  <!--选项卡-->
  <template>
    <el-tabs v-model="activeName" type="card" @tab-click="handleClick">
      <el-tab-pane label="题目" name="first">题目</el-tab-pane>
      <el-tab-pane label="讨论" name="second">讨论</el-tab-pane>
      <el-tab-pane label="题解" name="third">题解</el-tab-pane>
    </el-tabs>
  </template>

  <el-form ref="form" :model="blog" label-width="80px">
    <el-form-item label="题目">
      <el-input type="hidden" label-width="50px" disabled="disabled" v-model="blog.bid">${blog.bid}</el-input>
    </el-form-item>
    <el-form-item label="题目">
      <el-input label-width="50px" disabled="disabled" v-model="blog.title">${blog.title}</el-input>
    </el-form-item>

    <el-form-item label="题目具体信息">
      <el-input disabled="disabled" type="textarea" v-model="blog.content">${blog.content}</el-input>
    </el-form-item>

    <el-form-item label="要求">
      <el-input disabled="disabled" v-model="blog.outline">${blog.outline}</el-input>
    </el-form-item>
    <!--<el-form-item>
      <el-button circle> <a href="">评论</a> </el-button>
    </el-form-item>-->
  </el-form>
  <el-form :model="ValidateForm" ref="ValidateForm" label-width="100px" class="demo-ruleForm">
    <el-form-item
            label="代码"
            prop="code"
            :rules="[
      { required: true, message: '代码不能为空'},
    ]"
    >
      <el-input v-model.number="ValidateForm.code" type="textarea" autocomplete="off"></el-input>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="submitForm('ValidateForm')">提交</el-button>
      <el-button @click="resetForm('ValidateForm')">重置</el-button>
    </el-form-item>
  </el-form>

</div>


<script src="js/vue.js"></script>
<script src="element-ui/lib/index.js"></script>
<script src="js/axios-0.18.0.js"></script>
<link rel="stylesheet" href="element-ui/lib/theme-chalk/index.css">

<script>
  new Vue({
    el: "#app",
    created(){
    },
    mounted(){
      //在页面加载完成之后，发送异步请求，获取数据
      //this.forwardOn();
    },
    methods: {
      forwardOn(){
        axios({
          method: "post",
          url: "http://localhost:8080/brand-case/blog/selectBlog",
        }).then(resp => {
            this.blog = resp.data;
        })
      },
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {

            alert('submit!');
          } else {
            console.log('error submit!!');
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      },
      tableRowClassName({row, rowIndex}) {
        if (rowIndex === 1) {
          return 'warning-row';
        } else if (rowIndex === 3) {
          return 'success-row';
        }
        return '';
      },
      //点击标签页
      handleClick(tab, event) {
        console.log(tab, event);
      }
    },
    data() {
      return {
        ValidateForm: {
          code: ''
        },
        activeName: 'first',
        drawer: false,
        Bid:'',
        inputDis:'',
        btnColor:'',
        //数据上传
        fileList: [],
        //复选框选中的id
        selectedIds:[],
        //每页默认显示条数
        pageSize:5,
        //当前页面总数据
        totalCount:100,
        // 当前页码
        currentPage: 1,
        // 添加数据对话框是否展示的标记
        dialogVisible: false,
        updateVisible: false,
        viewvisible: false,
        // 品牌模型数据
        blog: {
          title: '',
          content: '输入两个整数，求这两个整数的和是多少。\n' +
                  '\n' +
                  '输入格式:\n' +
                  '输入两个整数A,B，用空格隔开\n' +
                  '\n' +
                  '输出格式:\n' +
                  '输出一个整数，表示这两个数的和\n' +
                  '\n' +
                  '数据范围:\n' +
                  '0≤A,B≤108\n' +
                  '样例输入:\n' +
                  '3 4\n' +
                  '样例输出:\n' +
                  '7',
          outline: '',
          bid: "",
          commentabled: "",
          likes: ""
        },
        // 复选框选中数据集合
        multipleSelection: [],
        // 表格数据
        tableData: [{
          title: 'vue框架',
          content: '题目具体信息---',
          outline: 'vue框架',
          likes: "1"
        }, {
          title: 'vue框架',
          content: '题目具体信息---',
          outline: 'vue框架',
          likes: "1"
        }, {
          title: 'vue框架',
          content: '题目具体信息---',
          outline: 'vue框架',
          likes: "1"
        }, {
          title: 'vue框架',
          content: '题目具体信息---',
          outline: 'vue框架',
          likes: "1"
        }]
      }
    }
  })

</script>

</body>
</html>

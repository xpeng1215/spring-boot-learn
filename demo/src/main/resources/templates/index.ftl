<html>
<head>
  <script src="https://cdn.jsdelivr.net/npm/vue"></script>
  <link th:href="@{/webjars/bootstrap/3.3.6/dist/css/bootstrap.css}" rel="stylesheet"></link>
</head>
<body>
  Welcome
  <p>当前时间为：${vv!}</p>

  <div id="app">
    {{ message }}
  </div>

  <div id="app-2">
  <span v-bind:title="message">
    鼠标悬停几秒钟查看此处动态绑定的提示信息！
  </span>
  </div>

  <div id="app-3">
    <p v-if="seen">现在你看到我了</p>
  </div>

  <div id="app-4">
    <ol>
      <li v-for="todo in todos">
        {{ todo.name }}{{ todo.text }}
      </li>
    </ol>
  </div>

  <div id="app-5">
    <p>{{ message }}</p>
    <button v-on:click="reverseMessage">逆转消息</button>
  </div>

  <ol>
    <!-- 创建一个 todo-item 组件的实例 -->
    <todo-item></todo-item>
  </ol>


  <script>
    var app = new Vue({
      el: '#app',
      data: {
        message: 'Hello Vue!'
      }
    });
    var app2 = new Vue({
      el: '#app-2',
      data: {
        message: '页面加载于 ' + new Date().toLocaleString()
      }
    });
    var app3 = new Vue({
      el: '#app-3',
      data: {
        seen: true
      }
    });
    var app4 = new Vue({
      el: '#app-4',
      data: {
        todos: [
          { text: '学习 JavaScript' , name: '你'},
          { text: '学习 Vue' , name: '我'},
          { text: '整个项目牛' , name: 'Vue'}
        ]
      }
    });
    var app5 = new Vue({
      el: '#app-5',
      data: {
        message: 'Hello Vue.js!'
      },
      methods: {
        reverseMessage: function () {
          this.message = this.message.split('').reverse().join('')
        }
      }
    });

    Vue.component('todo-item', {
      // todo-item 组件现在接受一个
      // "prop"，类似于一个自定义特性。
      // 这个 prop 名为 todo。
      props: ['todo'],
      template: '<li>{{ todo.text }}</li>'
    });
  </script>
</body>
</html>
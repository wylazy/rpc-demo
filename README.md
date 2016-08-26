<h3>Java RPC框架示例</h3>

<h4>RPC工作方式</h4>
<p>common包为RPC接口，客户端和服务器共享接口，使用FastJson作为序列化工具</p>

<p><strong>客户端部分：</strong></p>
<p>客户端API</p>
<p>客户端代理

<p><strong>服务器部分：</strong></p>
<p>服务器实现</p>
<p>服务器代理

<p><strong>示例程序：</strong></p>
<ul>
<li>通过RPC计算两个整数的和</li>
</ul>

<p>
客户端和服务器之间通过代理通信，客户端像调用本地方法一样调用RPC，实际上内部使用TCP/IP协议，客户端将请求发送到服务器，由服务器执行并返回结果。代理和代理之间要选择一个合适的序列化方法，这里选择的是Fastjson.
</p>

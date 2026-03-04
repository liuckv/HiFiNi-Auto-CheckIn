package cloud.ohiyou;

public class HifiniApplication {
    public static void main(String[] args) {
        // 这里只是简单的输出 cookie 值，实际操作你可以扩展为签到操作
        System.out.println("开始签到...");

        String cookie = System.getenv("COOKIE");  // 获取环境变量 COOKIE
        System.out.println("使用的 cookie: " + cookie);

        // 这里可以添加实际的签到逻辑，例如发送 HTTP 请求等
    }
}

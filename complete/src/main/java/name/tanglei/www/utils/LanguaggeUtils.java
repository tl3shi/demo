package name.tanglei.www.utils;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

/**
 * @author tanglei
 * @date 2020/5/10
 */
public class LanguaggeUtils {
    public static Locale currentLocale(HttpServletRequest request) {
        // 从 RequestHeader 等等获取相应的语言信息
        // 简单起见，直接从 queryParams 中取, 只模拟中英文
        String locale = request.getParameter("lang");
        if ("zh".equalsIgnoreCase(locale)) {
            return Locale.CHINA;
        } else {
            return Locale.ENGLISH;
        }
    }
}

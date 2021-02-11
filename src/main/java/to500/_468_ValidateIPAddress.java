package to500;


public class _468_ValidateIPAddress {


    public String validIPAddress(String IP) {
        if (isIPv4(IP)) {
            return "IPv4";
        } else if (isIPv6(IP.toUpperCase())) {
            return "IPv6";
        }
        return "Neither";
    }

    public boolean isIPv4(String IP) {
        int count = 0;
        for (char ch : IP.toCharArray()) {
            if (ch == '.') {
                count++;
            }
        }
        if (count != 3) {
            return false;
        }

        String[] fields = IP.split("\\.");
        if (fields.length != 4) {
            return false;
        }
        for (String field : fields) {
            if (field.isEmpty() || field.length() > 3) {
                return false;
            }
            for (int i = 0; i < field.length(); i++) {   // 视频 fields.length，IDE自动的写错了
                if (!Character.isDigit(field.charAt(i))) {
                    return false;
                }
            }
            int num = Integer.valueOf(field);
            if (!String.valueOf(num).equals(field) || num < 0 || num > 255) {  // 加个 ！，视频忘了加
                return false;
            }
        }
        return true;
    }

    public boolean isIPv6(String IP) {
        int count = 0;
        for (char ch : IP.toCharArray()) {
            if (ch == ':') {
                count++;
            }
        }
        if (count != 7) {
            return false;
        }

        String[] fields = IP.split(":");  // 视频忘改为 : 了
        if (fields.length != 8) {
            return false;
        }
        for (String field : fields) {
            if (field.isEmpty() || field.length() > 4) {
                return false;
            }
            for (int i = 0; i < field.length(); i++) {  // 视频 fields.length，IDE自动的写错了
                if (!Character.isDigit(field.charAt(i)) && (field.charAt(i) < 'A' || field.charAt(i) > 'F')) {
                    return false;
                }
            }
        }
        return true;
    }

}

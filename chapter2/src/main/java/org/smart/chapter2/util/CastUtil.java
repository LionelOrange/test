package org.smart.chapter2.util;

/**
 * 转型操作工具类
 * Created by chencheng on 2017-06-28.
 */
public final class CastUtil {
    /**
     * 转为String型
     *
     * @param obj
     * @return
     */
    public static String castString(Object obj) {
        return castString(obj, "");
    }

    /**
     * 转为String型(提供默认值)
     *
     * @param obj
     * @param defaultValue
     * @return
     */
    public static String castString(Object obj, String defaultValue) {
        return obj != null ? String.valueOf(obj) : defaultValue;
    }

    /**
     * 转为double型
     *
     * @param object
     * @return
     */
    public static double castDouble(Object object) {
        return castDouble(object, 0);
    }

    /**
     * 转为double型（提供默认值）
     *
     * @param obj
     * @param defaultValue
     * @return
     */
    public static double castDouble(Object obj, double defaultValue) {
        double doubleValue = defaultValue;
        if (obj != null) {
            String strValue = castString(obj);
            if (StringUtil.isNotEmpty(strValue)) {
                try {
                    doubleValue = Double.parseDouble(strValue);
                } catch (NumberFormatException e) {
                    doubleValue = defaultValue;
                }
            }
        }
        return doubleValue;
    }

    /**
     * 转为long型
     *
     * @param obj
     * @return
     */
    public static long castLong(Object obj) {
        return castLong(obj, 0);
    }

    /**
     * 转为long型（提供默认值）
     *
     * @param obj
     * @param defaultVaule
     * @return
     */
    public static long castLong(Object obj, long defaultVaule) {
        long longValue = defaultVaule;
        if (obj != null) {
            String strValue = castString(obj);
            if (StringUtil.isNotEmpty(strValue)) {
                try {
                    longValue = Long.parseLong(strValue);
                } catch (NumberFormatException e) {
                    longValue = defaultVaule;
                }
            }
        }
        return longValue;
    }

    /**
     * 转为int型
     *
     * @param obj
     * @return
     */
    public static int castInt(Object obj) {
        return castInt(obj, 0);
    }

    /**
     * 转为int型（提供默认值）
     *
     * @param obj
     * @param defaultVaule
     * @return
     */
    public static int castInt(Object obj, int defaultVaule) {
        int intValue = defaultVaule;
        if (obj != null) {
            String strValue = castString(obj);
            if (StringUtil.isNotEmpty(strValue)) {
                try {
                    intValue = Integer.parseInt(strValue);
                } catch (NumberFormatException e) {
                    intValue = defaultVaule;
                }
            }
        }
        return intValue;
    }

    /**
     * 转为boolean型
     *
     * @param obj
     * @return
     */
    public static boolean castBoolean(Object obj) {
        return castBoolean(obj, false);
    }

    /**
     * 转为boolean型（提供默认值）
     *
     * @param obj
     * @param defaultVaule
     * @return
     */
    public static boolean castBoolean(Object obj, boolean defaultVaule) {
        boolean booleanValue=defaultVaule;
        if (obj!=null){
            booleanValue=Boolean.parseBoolean(castString(obj));
        }
        return booleanValue;
    }
}

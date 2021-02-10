package com.wb.office.component.config;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName: PageOfficeButtonEnum
 * @Package: com.wb.office.component.config
 * @Description: the pageOffice button enum
 * @Author：[bo.wang]
 * @Date: 2021/2/10
 * @Version: 1.0
 */
public enum PageOfficeButtonEnum {

    SAVE("保存", "saveFile", 1, true, "保存按钮"),
    PRINT("打印", "printFile", 6, true, "打印按钮"),
    SWITCH_FULL_SCREEN("全屏切换", "switchFullScreen", 4, true, "全屏切换按钮"),
    DELIMITER("-", "", 0, false, "按钮中间分割符"),
    PRINT_PREVIEW("打印预览", "printPreview", 6, true, "打印预览按钮"),
    SAVE_AS_PDF("另存为PDF", "saveAsPdf", 7, true, "另存为PDF按钮"),
    SAVE_FILE_AND_CLOSE_WINDOW("保存并关闭", "saveFileAndCloseWindow", 7, true, "保存并关闭按钮"),
    SHOW_LANGUAGE("切换语言", "showLanguage", 7, false, "切换语言按钮");;

    //  the button name
    private String name;

    //  the js function name
    private String jsFunctionName;

    //  the icon index
    private int iconIndex;

    //  the is default
    private boolean isDefault;

    //  the description
    private String description;

    /**
     * constructs a new pageOffice button enum with the specified name
     * and js function name and icon index and is default and description.
     *
     * @param name           the button name
     * @param jsFunctionName the js function name
     * @param iconIndex      the icon index
     * @param isDefault      the is default
     * @param description    the description
     */
    PageOfficeButtonEnum(String name, String jsFunctionName, int iconIndex, boolean isDefault, String description) {
        this.name = name;
        this.jsFunctionName = jsFunctionName;
        this.iconIndex = iconIndex;
        this.isDefault = isDefault;
        this.description = description;
    }

    /**
     * get default buttons
     *
     * @return the default buttons
     */
    public static List<PageOfficeButtonEnum> getDefaultButton() {
        return Arrays.asList(PageOfficeButtonEnum.values()).stream().filter(button -> button.isDefault).collect(Collectors.toList());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJsFunctionName() {
        return jsFunctionName;
    }

    public void setJsFunctionName(String jsFunctionName) {
        this.jsFunctionName = jsFunctionName;
    }

    public int getIconIndex() {
        return iconIndex;
    }

    public void setIconIndex(int iconIndex) {
        this.iconIndex = iconIndex;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean aDefault) {
        isDefault = aDefault;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

package com.wb.office.component.handler;

import com.wb.office.component.config.PageOfficeButtonEnum;
import com.wb.office.component.config.PageOfficeConstant;
import com.zhuozhengsoft.pageoffice.PageOfficeCtrl;
import com.zhuozhengsoft.pageoffice.ThemeType;

import java.util.List;

/**
 * @ClassName: AbstractPageOfficeHandler
 * @Package: com.wb.office.component.handler
 * @Description: the abstract pageOffice handler
 * @Author：[bo.wang]
 * @Date: 2021/2/9
 * @Version: 1.0
 */
public abstract class AbstractPageOfficeHandler {

    //  the pageOffice ctrl
    private static PageOfficeCtrl officeCtrl = null;

    /**
     * load pageOffice
     *
     * @param loadHandler the pageOffice load handler
     * @param officeCtrl  the pageOffice ctrl
     */
    public void doLoad(PageOfficeHandler loadHandler, PageOfficeCtrl officeCtrl) {
        this.officeCtrl = officeCtrl;

        //  set caption
        officeCtrl.setCaption(setCaption());

        //  add custom tool button
        addCustomToolButton(officeCtrl);

        //  the set save data page
        officeCtrl.setSaveDataPage(setSaveDataPage());

        //  the set save file page
        officeCtrl.setSaveFilePage(setSaveFilePage());

        //  set is show menubar
        officeCtrl.setMenubar(setMenubar());

        //  set theme
        officeCtrl.setTheme(setTheme());

        //  custom pageOffice ctrl
        loadHandler.load(officeCtrl);
    }

    /**
     * set pageOffice caption
     *
     * @return the caption
     */
    public String setCaption() {
        return PageOfficeConstant.SERVER_NAME;
    }

    /**
     * add custom tool button
     *
     * @param officeCtrl the pageOffice ctrl
     */
    public void addCustomToolButton(PageOfficeCtrl officeCtrl) {
        this.addDefaultCustomToolButton();
    }

    /**
     * add default custom tool button
     */
    private void addDefaultCustomToolButton() {
        List<PageOfficeButtonEnum> defaultButtons = PageOfficeButtonEnum.getDefaultButton();
        defaultButtons.stream().forEach((button) -> {
            officeCtrl.addCustomToolButton(button.getName(), button.getJsFunctionName(), button.getIconIndex());
        });
    }

    /**
     * set save data page
     *
     * @return the save data page
     */
    public String setSaveDataPage() {
        return "";
    }

    /**
     * set save file page
     *
     * @return the save file page
     */
    public abstract String setSaveFilePage();

    /**
     * set theme
     *
     * @return the theme
     */
    public ThemeType setTheme() {
        return ThemeType.Office2010;
    }

    /**
     * set show menubar
     *
     * @return the is show menubar
     */
    public boolean setMenubar() {
        return false;
    }
}

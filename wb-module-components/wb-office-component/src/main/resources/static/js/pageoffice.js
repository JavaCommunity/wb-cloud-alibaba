/**
 * 保存文件
 */
function saveFile() {
    document.getElementById("PageOfficeCtrl1").WebSave();
}

/**
 * 另存为PDF
 */
function saveAsPdf() {
    document.getElementById("PageOfficeCtrl1").WebSaveAsPDF();
}

/**
 * 打印
 */
function printFile() {
    document.getElementById("PageOfficeCtrl1").ShowDialog(4);
}

/**
 * 保存文档并关闭窗口
 */
function saveFileAndCloseWindow() {
    saveFile()
    //  关闭当前窗口
    window.external.close();
}

/**
 * 切换语言
 */
function showLanguage() {
    document.getElementById("PageOfficeCtrl1").ShowLanguageBox();
}

/**
 * 在关闭文档之前调用
 */
function BeforeBrowserClosed() {
    //IsDirty属性只对word文档有效
    if (document.getElementById("PageOfficeCtrl1").IsDirty) {
        if (confirm("提示：文档已被修改，是否继续关闭放弃保存 ？")) {
            return true;
        } else {
            return false;
        }
    }
}

/**
 * 自动保存文档
 */
setInterval("WebSave()", 1000 * 60);//假设每分钟保存一次
function WebSave() {
    document.getElementById("PageOfficeCtrl1").AutoWebSave();
}

/**
 * 打印预览
 */
function printPreview() {
    document.getElementById("PageOfficeCtrl1").PrintPreview();
}

/**
 * 全屏切换
 */
function switchFullScreen() {
    document.getElementById("PageOfficeCtrl1").FullScreen = !document.getElementById("PageOfficeCtrl1").FullScreen;
}
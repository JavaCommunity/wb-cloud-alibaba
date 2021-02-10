package com.wb.office.component.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @ClassName: PageOfficeRequest
 * @Package: com.wb.office.component.request
 * @Description: the pageOffice request
 * @Author：[bo.wang]
 * @Date: 2021/1/29
 * @Version: 1.0
 */
@ApiModel(value = "PageOfficeRequest", description = "pageOffice打开窗口请求类")
public class PageOfficeRequest implements Serializable {

    @ApiModelProperty(value = "文件ID")
    private String fileId;

    @ApiModelProperty(value = "PageOffice Handler Code")
    private String businessCode;

    @ApiModelProperty(value = "业务数据ID")
    private String businessDataId;

    @ApiModelProperty(value = "权限，为空则表示只有查看权限,{READ_ONLY:只读,EDIT:可编辑}")
    private String authorityType;

    @ApiModelProperty(value = "如果需要打开本地文件，这里指定本地文件地址")
    private String localFilePath;

    @ApiModelProperty(value = "pageOffice窗口需要打开的页面")
    private String openWindowPage;

    @ApiModelProperty(value = "文件类型")
    private String fileType;

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getBusinessCode() {
        return businessCode;
    }

    public void setBusinessCode(String businessCode) {
        this.businessCode = businessCode;
    }

    public String getBusinessDataId() {
        return businessDataId;
    }

    public void setBusinessDataId(String businessDataId) {
        this.businessDataId = businessDataId;
    }

    public String getAuthorityType() {
        return authorityType;
    }

    public void setAuthorityType(String authorityType) {
        this.authorityType = authorityType;
    }

    public String getLocalFilePath() {
        return localFilePath;
    }

    public void setLocalFilePath(String localFilePath) {
        this.localFilePath = localFilePath;
    }

    public String getOpenWindowPage() {
        return openWindowPage;
    }

    public void setOpenWindowPage(String openWindowPage) {
        this.openWindowPage = openWindowPage;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }
}

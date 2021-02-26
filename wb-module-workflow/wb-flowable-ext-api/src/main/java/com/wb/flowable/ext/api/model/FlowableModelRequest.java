package com.wb.flowable.ext.api.model;

import com.wb.flowable.ext.api.request.FlowableRequest;

/**
 * @ClassName: FlowableModelRequest
 * @Package: com.wb.flowable.ext.api.model
 * @Description: the flowable model request
 * @Author：[bo.wang]
 * @Date: 2021/2/18
 * @Version: 1.0
 */
public class FlowableModelRequest extends FlowableRequest {

    //  the code
    private String code;

    //  the name
    private String name;

    //  the model id
    private String modelId;

    //  the json xml
    private String jsonXml;

    //  the svg xml
    private String svgXml;

    //  the description
    private String description;

    /**
     * constructs a new flowableModelRequest.
     */
    public FlowableModelRequest() {
    }

    /**
     * constructs a new flowableModelRequest with the specified the model id
     * and model id and json xml and svg xml.
     *
     * @param modelId the model id
     * @param jsonXml the json xml
     * @param svgXml  the svg xml
     */
    public FlowableModelRequest(String modelId, String jsonXml, String svgXml) {
        this.modelId = modelId;
        this.jsonXml = jsonXml;
        this.svgXml = svgXml;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    public String getJsonXml() {
        return jsonXml;
    }

    public void setJsonXml(String jsonXml) {
        this.jsonXml = jsonXml;
    }

    public String getSvgXml() {
        return svgXml;
    }

    public void setSvgXml(String svgXml) {
        this.svgXml = svgXml;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

package com.wb.sign.component.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @ClassName: SignProperties
 * @Package: com.wb.sign.component.config
 * @Description: the sign properties
 * @Author：[bo.wang]
 * @Date: 2021/3/22
 * @Version: 1.0
 */
@ConfigurationProperties(prefix = "wb-cloud.sign")
public class SignProperties {

    //  the default sign type
    private static final String DEFAULT_SIGN_TYPE = SignTypeEnum.EBAO.name();

    //  the sign type
    private String type = DEFAULT_SIGN_TYPE;

    //  the e bao properties
    private SignEBaoProperties eBao;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public SignEBaoProperties geteBao() {
        return eBao;
    }

    public void seteBao(SignEBaoProperties eBao) {
        this.eBao = eBao;
    }
}

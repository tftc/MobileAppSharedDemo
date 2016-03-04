package cn.com.jinrizhushi;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "COUNSELOR_EXT_INFO".
 */
public class CounselorExtInfo implements java.io.Serializable {

    private Long id;
    private Integer authentication;
    private String certificationGroup;
    private Long create_time;
    private String description_content;

    public CounselorExtInfo() {
    }

    public CounselorExtInfo(Long id) {
        this.id = id;
    }

    public CounselorExtInfo(Long id, Integer authentication, String certificationGroup, Long create_time, String description_content) {
        this.id = id;
        this.authentication = authentication;
        this.certificationGroup = certificationGroup;
        this.create_time = create_time;
        this.description_content = description_content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAuthentication() {
        return authentication;
    }

    public void setAuthentication(Integer authentication) {
        this.authentication = authentication;
    }

    public String getCertificationGroup() {
        return certificationGroup;
    }

    public void setCertificationGroup(String certificationGroup) {
        this.certificationGroup = certificationGroup;
    }

    public Long getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Long create_time) {
        this.create_time = create_time;
    }

    public String getDescription_content() {
        return description_content;
    }

    public void setDescription_content(String description_content) {
        this.description_content = description_content;
    }

}

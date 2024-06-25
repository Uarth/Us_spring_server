package ybigta.us.dto;

public class RecordDto {
    private String recordName;
    private String recordS3Url;
    private Integer questionNumber;

    public RecordDto(String recordName, String recordS3Url, Integer recordNumber) {
        this.recordName = recordName;
        this.recordS3Url = recordS3Url;
        this.questionNumber = recordNumber;
    }
    public RecordDto(String recordName, String recordS3Url) {
        this.recordName = recordName;
        this.recordS3Url = recordS3Url;
    }

    public String getRecordName() {
        return recordName;
    }

    public void setRecordName(String recordName) {
        this.recordName = recordName;
    }

    public String getRecordS3Url() {
        return recordS3Url;
    }

    public void setRecordS3Url(String recordS3Url) {
        this.recordS3Url = recordS3Url;
    }

    public Integer getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(Integer questionNumber) {
        this.questionNumber = questionNumber;
    }
}

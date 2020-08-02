package cn.wfc.shop.entity;

public class BaseResult {
    private boolean success;
    private String msg;
    private Object data;

    public static BaseResult success(Object data) {
        BaseResult baseResult = new BaseResult();
        baseResult.setData(data);
        baseResult.setSuccess(true);
        return baseResult;
    }

    public static BaseResult fail(String msg){
        BaseResult baseResult = new BaseResult();
        baseResult.setSuccess(false);
        baseResult.setMsg(msg);
        return baseResult;
    }
    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

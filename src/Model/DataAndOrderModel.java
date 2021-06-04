package Model;

/**
 * Created by srikar on 04-06-2021.
 */

public class DataAndOrderModel {
    private int[] data;
    private String order;

    public DataAndOrderModel(int[] data, String order) {
        this.data = data;
        this.order = order;
    }

    public int[] getData() {
        return data;
    }

    public void setData(int[] data) {
        this.data = data;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

}

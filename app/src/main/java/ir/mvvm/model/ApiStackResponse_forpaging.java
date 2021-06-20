package ir.mvvm.model;

import java.util.List;

public class ApiStackResponse_forpaging {
    public List<ItemModel_forpaging> items;
    public boolean has_more;
    public int backoff,quota_max,quota_remaining;
}

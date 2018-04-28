
package test.platzi.com.raian.com.org.simpledynamit.model.city;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Meta {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("license")
    @Expose
    private String license;
    @SerializedName("website")
    @Expose
    private String website;
    @SerializedName("page")
    @Expose
    private int page;
    @SerializedName("limit")
    @Expose
    private int limit;
    @SerializedName("found")
    @Expose
    private int found;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getFound() {
        return found;
    }

    public void setFound(int found) {
        this.found = found;
    }

}

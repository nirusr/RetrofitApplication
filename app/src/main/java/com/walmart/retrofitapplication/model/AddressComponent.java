
package com.walmart.retrofitapplication.model;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class AddressComponent {

    private String longName;
    private String shortName;
    private List<String> types = new ArrayList<String>();

    /**
     * 
     * @return
     *     The longName
     */
    public String getLongName() {
        return longName;
    }

    /**
     * 
     * @param longName
     *     The long_name
     */
    public void setLongName(String longName) {
        this.longName = longName;
    }

    /**
     * 
     * @return
     *     The shortName
     */
    public String getShortName() {
        return shortName;
    }

    /**
     * 
     * @param shortName
     *     The short_name
     */
    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    /**
     * 
     * @return
     *     The types
     */
    public List<String> getTypes() {
        return types;
    }

    /**
     * 
     * @param types
     *     The types
     */
    public void setTypes(List<String> types) {
        this.types = types;
    }

}

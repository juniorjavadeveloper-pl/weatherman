
package pl.juniorjavadeveloper.project.weatherman.external.api.openweather.model.current;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.processing.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "1h"
})
@Generated("jsonschema2pojo")
public class Rain {

    @JsonProperty("1h")
    private Double _1h;

    @JsonProperty("1h")
    public Double get1h() {
        return _1h;
    }

    @JsonProperty("1h")
    public void set1h(Double _1h) {
        this._1h = _1h;
    }

    @Override
    public String toString() {
        return "Rain{" +
                "_1h=" + _1h +
                '}';
    }

}

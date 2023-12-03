package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class Resposta {

    @JsonProperty("Resposta")
    String respostaJson;

@Override
    public String  toString()
{
    return respostaJson;
}
}

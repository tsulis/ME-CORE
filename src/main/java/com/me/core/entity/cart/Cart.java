package com.me.core.entity.cart;

import com.me.core.entity.BaseMongo;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Document(collection = "cart")
public class Cart extends BaseMongo implements Serializable {

  private String cardId;

}

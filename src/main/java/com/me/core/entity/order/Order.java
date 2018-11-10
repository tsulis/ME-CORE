package com.me.core.entity.order;

import com.me.core.entity.BaseMongo;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Order extends BaseMongo implements Serializable {

  private String orderId;
  private String orderReference;
  private String channel; //pos

}

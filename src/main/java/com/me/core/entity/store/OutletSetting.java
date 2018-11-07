package com.me.core.entity.store;

import com.me.core.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class OutletSetting extends BaseEntity implements Serializable {

  private static final long serialVersionUID = 6155928175993568365L;
  private String photoUrl;
  private boolean alwaysPrintReceipt;
  private boolean alwaysFulfillOrder;
  private boolean useAudioJackForCardReader;
  private boolean autoLockScreen;
  private String customSettings;

  @Builder
  public OutletSetting(Date createdDate, String createdBy, Date updatedDate,
      String updatedBy, boolean isDeleted, boolean isActive, Date syncTime,
      String timestamp, String photoUrl, boolean alwaysPrintReceipt, boolean alwaysFulfillOrder,
      boolean useAudioJackForCardReader, boolean autoLockScreen, String customSettings) {
    super(createdDate, createdBy, updatedDate, updatedBy, isDeleted, isActive, syncTime, timestamp);
    this.photoUrl = photoUrl;
    this.alwaysPrintReceipt = alwaysPrintReceipt;
    this.alwaysFulfillOrder = alwaysFulfillOrder;
    this.useAudioJackForCardReader = useAudioJackForCardReader;
    this.autoLockScreen = autoLockScreen;
    this.customSettings = customSettings;
  }
}

package com.me.core.libraries.utility;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class BarcodeGenerator {

  public static void generate(String data, String barcodeName, String path)
      throws IOException, WriterException {

    int width = 400;
    int height = 300; // change the height and width as per your requirement

    String imageFormat = "png"; // could be "gif", "tiff", "jpeg"

    BitMatrix bitMatrix = new QRCodeWriter().encode(data, BarcodeFormat.QR_CODE, width, height);

    MatrixToImageWriter.writeToStream(bitMatrix, imageFormat,
        new FileOutputStream(new File(path + barcodeName + "." + imageFormat)));
  }
}

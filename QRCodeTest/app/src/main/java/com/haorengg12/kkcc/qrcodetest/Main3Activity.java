package com.haorengg12.kkcc.qrcodetest;

import com.journeyapps.barcodescanner.CaptureActivity;
import com.journeyapps.barcodescanner.DecoratedBarcodeView;

/*
* 扫描摄像头样式
* */

public class Main3Activity extends CaptureActivity {
    @Override
    protected DecoratedBarcodeView initializeContent() {
        setContentView(R.layout.activity_main3);
        return (DecoratedBarcodeView) findViewById(R.id.zxing_barcode_scanner);

    }
}
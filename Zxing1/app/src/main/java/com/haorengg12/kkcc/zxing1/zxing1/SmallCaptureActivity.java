package com.haorengg12.kkcc.zxing1.zxing1;

import com.haorengg12.kkcc.zxing1.R;
import com.journeyapps.barcodescanner.CaptureActivity;
import com.journeyapps.barcodescanner.DecoratedBarcodeView;

/**
 * Created by 黄黄k on 2017-11-23.
 */

public class SmallCaptureActivity extends CaptureActivity {
    @Override
    protected DecoratedBarcodeView initializeContent() {
        setContentView(R.layout.capture_small);
        return (DecoratedBarcodeView)findViewById(R.id.zxing_barcode_scanner);
    }
}

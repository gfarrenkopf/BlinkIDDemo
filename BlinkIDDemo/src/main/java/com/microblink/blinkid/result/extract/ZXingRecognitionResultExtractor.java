package com.microblink.blinkid.result.extract;

import android.content.Context;

import com.microblink.blinkid.R;
import com.microblink.recognizers.BaseRecognitionResult;
import com.microblink.recognizers.barcode.BarcodeType;
import com.microblink.recognizers.barcode.zxing.ZXingScanResult;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dodo on 25/09/15.
 */
public class ZXingRecognitionResultExtractor implements IBaseRecognitionResultExtractor {
    private Context mContext;
    private List<RecognitionResultEntry> mExtractedData;

    public ZXingRecognitionResultExtractor(Context mContext) {
        this.mContext = mContext;
        mExtractedData = new ArrayList<>();
    }

    /**
     * Returns list with extracted entries.
     *
     * @param result BaseRecognitionResult
     * @return list with extracted entries
     */
    @Override
    public List<RecognitionResultEntry> extractData(BaseRecognitionResult result) {
        if (result == null) {
            return mExtractedData;
        }

        if (result instanceof ZXingScanResult) {
            // result is obtained from scanning PDF417 barcode
            ZXingScanResult zxingResult = (ZXingScanResult) result;

            mExtractedData.add(new RecognitionResultEntry(
                    mContext.getString(R.string.PPBarcodeType),
                    zxingResult.getBarcodeType().name()
            ));

            mExtractedData.add(new RecognitionResultEntry(
                    mContext.getString(R.string.PPBarcodeData),
                    zxingResult.getStringData()
            ));

            if (zxingResult.getBarcodeType() == BarcodeType.CODE39) {
                // special case for code39 barcodes that can have special extended encoding
                mExtractedData.add(new RecognitionResultEntry(
                        mContext.getString(R.string.PPExtendedBarcodeData),
                        zxingResult.getExtendedStringData()
                ));
            }
        }

        return mExtractedData;
    }
}

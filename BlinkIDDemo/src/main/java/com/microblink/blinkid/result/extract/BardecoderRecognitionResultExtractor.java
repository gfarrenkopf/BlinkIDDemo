package com.microblink.blinkid.result.extract;

import android.content.Context;

import com.microblink.blinkid.R;
import com.microblink.recognizers.BaseRecognitionResult;
import com.microblink.recognizers.barcode.BarcodeType;
import com.microblink.recognizers.barcode.bardecoder.BarDecoderScanResult;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dodo on 25/09/15.
 */
public class BardecoderRecognitionResultExtractor implements IBaseRecognitionResultExtractor {
    private Context mContext;
    private List<RecognitionResultEntry> mExtractedData;

    public BardecoderRecognitionResultExtractor(Context mContext) {
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

        if (result instanceof BarDecoderScanResult) {
            // result is obtained from scanning PDF417 barcode
            BarDecoderScanResult barcodeResult = (BarDecoderScanResult) result;

            mExtractedData.add(new RecognitionResultEntry(
                    mContext.getString(R.string.PPBarcodeType),
                    barcodeResult.getBarcodeType().name()
            ));

            mExtractedData.add(new RecognitionResultEntry(
                    mContext.getString(R.string.PPBarcodeData),
                    barcodeResult.getStringData()
            ));

            if (barcodeResult.getBarcodeType() == BarcodeType.CODE39) {
                // special case for code39 barcodes that can have special extended encoding
                mExtractedData.add(new RecognitionResultEntry(
                        mContext.getString(R.string.PPExtendedBarcodeData),
                        barcodeResult.getExtendedStringData()
                ));
            }
        }

        return mExtractedData;
    }
}

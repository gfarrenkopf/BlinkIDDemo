package com.microblink.blinkid.result.extract;

import android.content.Context;
import android.os.Bundle;

import com.microblink.recognizers.BaseRecognitionResult;
import com.microblink.recognizers.ocr.blinkocr.BlinkOCRRecognitionResult;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dodo on 25/09/15.
 */
public class BlinkOcrRecognitionResultExtractor implements IBaseRecognitionResultExtractor {
    private Context mContext;
    private List<RecognitionResultEntry> mExtractedData;

    public BlinkOcrRecognitionResultExtractor(Context mContext) {
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

        if (result instanceof BlinkOCRRecognitionResult) {
            BlinkOCRRecognitionResult blinkOcrResult = (BlinkOCRRecognitionResult) result;

            // you can retrieve parsed element with getParsedResult method. The key
            // that should be used is the same as scan configuration's "parser name" (3rd)
            // constructor argument
            // For example to retrieve parsed IBAN, provided we installed parser with name "IBAN":
            // String iban = blinkOcrResult.getParsedResult("IBAN");

            // here we will extract all elements from result
            Bundle data = blinkOcrResult.getData();
            for(String key : data.keySet()) {
                String s = data.getString(key);
                // it is possible to have non-string data in bundle
                if (s != null) {
                    mExtractedData.add(new RecognitionResultEntry(key, s));
                }
            }

        }

        return mExtractedData;
    }
}

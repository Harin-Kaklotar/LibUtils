package com.codyy.lib.utils;

import android.net.Uri;

import com.facebook.cache.common.CacheKey;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.cache.DefaultCacheKeyFactory;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.facebook.imagepipeline.request.ImageRequest;

/**
 * Created by lijian on 2016/10/27 0027.
 */

public class FrescoUtils {
    public static boolean isDownloaded(Uri loadUri) {
        if (loadUri == null) {
            return false;
        }
        ImageRequest imageRequest = ImageRequest.fromUri(loadUri);
        CacheKey cacheKey = DefaultCacheKeyFactory.getInstance()
                .getEncodedCacheKey(imageRequest,null);
        return ImagePipelineFactory.getInstance()
                .getMainFileCache().hasKey(cacheKey);
    }

    public static boolean isDownloaded2(Uri loadUri) {
        ImagePipeline imagePipeline = Fresco.getImagePipeline();
        return imagePipeline.isInBitmapMemoryCache(loadUri);
    }
}

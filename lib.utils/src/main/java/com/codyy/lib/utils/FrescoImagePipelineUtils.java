package com.codyy.lib.utils;

import android.net.Uri;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

/**
 * Created by xiaojian on 2016/6/18.
 */
public class FrescoImagePipelineUtils {
    public static DraweeController getDraweeController(Uri uri, SimpleDraweeView simpleDraweeView) {
        ImageRequestBuilder imageRequestBuilder = ImageRequestBuilder.newBuilderWithSource(uri);
        imageRequestBuilder.setResizeOptions(new ResizeOptions(
                simpleDraweeView.getLayoutParams().width,
                simpleDraweeView.getLayoutParams().height));
        ImageRequest imageRequest = imageRequestBuilder.setLocalThumbnailPreviewsEnabled(true).build();
        DraweeController draweeController = Fresco.newDraweeControllerBuilder()
                .setImageRequest(imageRequest)
                .setOldController(simpleDraweeView.getController())
                .setAutoPlayAnimations(true)
                .build();
        return draweeController;
    }
}

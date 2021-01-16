package com.google.firebase.inappmessaging.model;

import android.text.TextUtils;
import com.google.common.base.Preconditions;
import com.google.firebase.inappmessaging.MessagesProto;
import javax.annotation.Nonnull;
import javax.inject.Singleton;

@Singleton
public class ProtoMarshallerClient {
  private static Action.Builder decode(MessagesProto.Action paramAction) {
    Action.Builder builder = Action.builder();
    if (!TextUtils.isEmpty(paramAction.getActionUrl()))
      builder.setActionUrl(paramAction.getActionUrl()); 
    return builder;
  }
  
  private static Action decode(MessagesProto.Action paramAction, MessagesProto.Button paramButton) {
    Action.Builder builder = decode(paramAction);
    if (paramButton != null) {
      Button.Builder builder1 = Button.builder();
      if (!TextUtils.isEmpty(paramButton.getButtonHexColor()))
        builder1.setButtonHexColor(paramButton.getButtonHexColor()); 
      if (paramButton.hasText()) {
        Text.Builder builder2 = Text.builder();
        MessagesProto.Text text = paramButton.getText();
        if (!TextUtils.isEmpty(text.getText()))
          builder2.setText(text.getText()); 
        if (!TextUtils.isEmpty(text.getHexColor()))
          builder2.setHexColor(text.getHexColor()); 
        builder1.setText(builder2.build());
      } 
      builder.setButton(builder1.build());
    } 
    return builder.build();
  }
  
  private static Button decode(MessagesProto.Button paramButton) {
    Button.Builder builder = Button.builder();
    if (!TextUtils.isEmpty(paramButton.getButtonHexColor()))
      builder.setButtonHexColor(paramButton.getButtonHexColor()); 
    if (paramButton.hasText())
      builder.setText(decode(paramButton.getText())); 
    return builder.build();
  }
  
  public static InAppMessage decode(@Nonnull MessagesProto.Content paramContent, String paramString1, String paramString2, boolean paramBoolean) {
    Preconditions.checkNotNull(paramContent, "FirebaseInAppMessaging content cannot be null.");
    CampaignMetadata campaignMetadata = new CampaignMetadata(paramString1, paramString2, paramBoolean);
    switch (paramContent.getMessageDetailsCase()) {
      default:
        return new InAppMessage(new CampaignMetadata(paramString1, paramString2, paramBoolean), MessageType.UNSUPPORTED) {
            public Action getAction() {
              return null;
            }
          };
      case CARD:
        return from(paramContent.getCard()).build(campaignMetadata);
      case MODAL:
        return from(paramContent.getModal()).build(campaignMetadata);
      case IMAGE_ONLY:
        return from(paramContent.getImageOnly()).build(campaignMetadata);
      case BANNER:
        break;
    } 
    return from(paramContent.getBanner()).build(campaignMetadata);
  }
  
  private static Text decode(MessagesProto.Text paramText) {
    Text.Builder builder = Text.builder();
    if (!TextUtils.isEmpty(paramText.getHexColor()))
      builder.setHexColor(paramText.getHexColor()); 
    if (!TextUtils.isEmpty(paramText.getText()))
      builder.setText(paramText.getText()); 
    return builder.build();
  }
  
  @Nonnull
  private static BannerMessage.Builder from(MessagesProto.BannerMessage paramBannerMessage) {
    BannerMessage.Builder builder = BannerMessage.builder();
    if (!TextUtils.isEmpty(paramBannerMessage.getBackgroundHexColor()))
      builder.setBackgroundHexColor(paramBannerMessage.getBackgroundHexColor()); 
    if (!TextUtils.isEmpty(paramBannerMessage.getImageUrl()))
      builder.setImageData(ImageData.builder().setImageUrl(paramBannerMessage.getImageUrl()).build()); 
    if (paramBannerMessage.hasAction())
      builder.setAction(decode(paramBannerMessage.getAction()).build()); 
    if (paramBannerMessage.hasBody())
      builder.setBody(decode(paramBannerMessage.getBody())); 
    if (paramBannerMessage.hasTitle())
      builder.setTitle(decode(paramBannerMessage.getTitle())); 
    return builder;
  }
  
  @Nonnull
  private static CardMessage.Builder from(MessagesProto.CardMessage paramCardMessage) {
    CardMessage.Builder builder = CardMessage.builder();
    if (paramCardMessage.hasTitle())
      builder.setTitle(decode(paramCardMessage.getTitle())); 
    if (paramCardMessage.hasBody())
      builder.setBody(decode(paramCardMessage.getBody())); 
    if (!TextUtils.isEmpty(paramCardMessage.getBackgroundHexColor()))
      builder.setBackgroundHexColor(paramCardMessage.getBackgroundHexColor()); 
    if (paramCardMessage.hasPrimaryAction())
      builder.setPrimaryAction(decode(paramCardMessage.getPrimaryAction()).build()); 
    if (paramCardMessage.hasSecondaryAction())
      builder.setSecondaryAction(decode(paramCardMessage.getSecondaryAction()).build()); 
    if (!TextUtils.isEmpty(paramCardMessage.getPortraitImageUrl()))
      builder.setPortraitImageData(ImageData.builder().setImageUrl(paramCardMessage.getPortraitImageUrl()).build()); 
    if (!TextUtils.isEmpty(paramCardMessage.getLandscapeImageUrl()))
      builder.setLandscapeImageData(ImageData.builder().setImageUrl(paramCardMessage.getLandscapeImageUrl()).build()); 
    return builder;
  }
  
  @Nonnull
  private static ImageOnlyMessage.Builder from(MessagesProto.ImageOnlyMessage paramImageOnlyMessage) {
    ImageOnlyMessage.Builder builder = ImageOnlyMessage.builder();
    if (!TextUtils.isEmpty(paramImageOnlyMessage.getImageUrl()))
      builder.setImageData(ImageData.builder().setImageUrl(paramImageOnlyMessage.getImageUrl()).build()); 
    if (paramImageOnlyMessage.hasAction())
      builder.setAction(decode(paramImageOnlyMessage.getAction()).build()); 
    return builder;
  }
  
  @Nonnull
  private static ModalMessage.Builder from(MessagesProto.ModalMessage paramModalMessage) {
    ModalMessage.Builder builder = ModalMessage.builder();
    if (!TextUtils.isEmpty(paramModalMessage.getBackgroundHexColor()))
      builder.setBackgroundHexColor(paramModalMessage.getBackgroundHexColor()); 
    if (!TextUtils.isEmpty(paramModalMessage.getImageUrl()))
      builder.setImageData(ImageData.builder().setImageUrl(paramModalMessage.getImageUrl()).build()); 
    if (paramModalMessage.hasAction())
      builder.setAction(decode(paramModalMessage.getAction(), paramModalMessage.getActionButton())); 
    if (paramModalMessage.hasBody())
      builder.setBody(decode(paramModalMessage.getBody())); 
    if (paramModalMessage.hasTitle())
      builder.setTitle(decode(paramModalMessage.getTitle())); 
    return builder;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\model\ProtoMarshallerClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
package com.google.firebase.inappmessaging.internal;

import com.google.common.annotations.VisibleForTesting;

final class AnalyticsConstants {
  @VisibleForTesting
  static final String ANALYTICS_ACTION_EVENT = "firebase_in_app_message_action";
  
  @VisibleForTesting
  static final String ANALYTICS_DISMISS_EVENT = "firebase_in_app_message_dismiss";
  
  @VisibleForTesting
  static final String ANALYTICS_IMPRESSION_EVENT = "firebase_in_app_message_impression";
  
  static final String ANALYTICS_MESSAGE_USE_DEVICE_TIME = "google.c.a.udt";
  
  static final String BUNDLE_EVENT_NAME_KEY = "events";
  
  static final String EVENT_FIREBASE_CAMPAIGN = "_cmp";
  
  static final String EVENT_NOTIFICATION_DISMISS = "_nd";
  
  static final String EVENT_NOTIFICATION_OPEN = "_no";
  
  static final int FIAM_ANALYTICS_CONNECTOR_LISTENER_EVENT_ID = 2;
  
  static final int MAX_REGISTERED_EVENTS = 50;
  
  static final String ORIGIN_FIAM = "fiam";
  
  static final String PARAM_CAMPAIGN = "campaign";
  
  static final String PARAM_LABEL = "label";
  
  static final String PARAM_MEDIUM = "medium";
  
  static final String PARAM_MESSAGE_DEVICE_TIME = "_ndt";
  
  static final String PARAM_MESSAGE_ID = "_nmid";
  
  static final String PARAM_MESSAGE_NAME = "_nmn";
  
  static final String PARAM_MESSAGE_TIME = "_nmt";
  
  static final String PARAM_SOURCE = "source";
  
  static final String USER_PROPERTY_FIREBASE_LAST_NOTIFICATION = "_ln";
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\internal\AnalyticsConstants.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
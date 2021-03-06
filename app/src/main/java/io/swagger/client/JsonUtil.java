package io.swagger.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;
import io.swagger.client.model.*;

public class JsonUtil {
  public static GsonBuilder gsonBuilder;

  static {
    gsonBuilder = new GsonBuilder();
    gsonBuilder.serializeNulls();
    gsonBuilder.setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
  }

  public static Gson getGson() {
    return gsonBuilder.create();
  }

  public static String serialize(Object obj){
    return getGson().toJson(obj);
  }

  public static <T> T deserializeToList(String jsonString, Class cls){
    return getGson().fromJson(jsonString, getListTypeForDeserialization(cls));
  }

  public static <T> T deserializeToObject(String jsonString, Class cls){
    return getGson().fromJson(jsonString, getTypeForDeserialization(cls));
  }

  public static Type getListTypeForDeserialization(Class cls) {
    String className = cls.getSimpleName();
    
    if ("AggregatedDeltaResponse".equalsIgnoreCase(className)) {
      return new TypeToken<List<AggregatedDeltaResponse>>(){}.getType();
    }
    
    if ("AnnouncementRecord".equalsIgnoreCase(className)) {
      return new TypeToken<List<AnnouncementRecord>>(){}.getType();
    }
    
    if ("AuthenticationResponse".equalsIgnoreCase(className)) {
      return new TypeToken<List<AuthenticationResponse>>(){}.getType();
    }
    
    if ("DealerRecord".equalsIgnoreCase(className)) {
      return new TypeToken<List<DealerRecord>>(){}.getType();
    }
    
    if ("DeltaResponseAnnouncementRecord".equalsIgnoreCase(className)) {
      return new TypeToken<List<DeltaResponseAnnouncementRecord>>(){}.getType();
    }
    
    if ("DeltaResponseDealerRecord".equalsIgnoreCase(className)) {
      return new TypeToken<List<DeltaResponseDealerRecord>>(){}.getType();
    }
    
    if ("DeltaResponseEventConferenceDayRecord".equalsIgnoreCase(className)) {
      return new TypeToken<List<DeltaResponseEventConferenceDayRecord>>(){}.getType();
    }
    
    if ("DeltaResponseEventConferenceRoomRecord".equalsIgnoreCase(className)) {
      return new TypeToken<List<DeltaResponseEventConferenceRoomRecord>>(){}.getType();
    }
    
    if ("DeltaResponseEventConferenceTrackRecord".equalsIgnoreCase(className)) {
      return new TypeToken<List<DeltaResponseEventConferenceTrackRecord>>(){}.getType();
    }
    
    if ("DeltaResponseEventRecord".equalsIgnoreCase(className)) {
      return new TypeToken<List<DeltaResponseEventRecord>>(){}.getType();
    }
    
    if ("DeltaResponseImageRecord".equalsIgnoreCase(className)) {
      return new TypeToken<List<DeltaResponseImageRecord>>(){}.getType();
    }
    
    if ("DeltaResponseKnowledgeEntryRecord".equalsIgnoreCase(className)) {
      return new TypeToken<List<DeltaResponseKnowledgeEntryRecord>>(){}.getType();
    }
    
    if ("DeltaResponseKnowledgeGroupRecord".equalsIgnoreCase(className)) {
      return new TypeToken<List<DeltaResponseKnowledgeGroupRecord>>(){}.getType();
    }
    
    if ("DeltaResponseMapRecord".equalsIgnoreCase(className)) {
      return new TypeToken<List<DeltaResponseMapRecord>>(){}.getType();
    }
    
    if ("EventConferenceDayRecord".equalsIgnoreCase(className)) {
      return new TypeToken<List<EventConferenceDayRecord>>(){}.getType();
    }
    
    if ("EventConferenceRoomRecord".equalsIgnoreCase(className)) {
      return new TypeToken<List<EventConferenceRoomRecord>>(){}.getType();
    }
    
    if ("EventConferenceTrackRecord".equalsIgnoreCase(className)) {
      return new TypeToken<List<EventConferenceTrackRecord>>(){}.getType();
    }
    
    if ("EventFeedbackRecord".equalsIgnoreCase(className)) {
      return new TypeToken<List<EventFeedbackRecord>>(){}.getType();
    }
    
    if ("EventRecord".equalsIgnoreCase(className)) {
      return new TypeToken<List<EventRecord>>(){}.getType();
    }
    
    if ("ImageRecord".equalsIgnoreCase(className)) {
      return new TypeToken<List<ImageRecord>>(){}.getType();
    }
    
    if ("KnowledgeEntryRecord".equalsIgnoreCase(className)) {
      return new TypeToken<List<KnowledgeEntryRecord>>(){}.getType();
    }
    
    if ("KnowledgeGroupRecord".equalsIgnoreCase(className)) {
      return new TypeToken<List<KnowledgeGroupRecord>>(){}.getType();
    }
    
    if ("LinkFragment".equalsIgnoreCase(className)) {
      return new TypeToken<List<LinkFragment>>(){}.getType();
    }
    
    if ("MapEntryRecord".equalsIgnoreCase(className)) {
      return new TypeToken<List<MapEntryRecord>>(){}.getType();
    }
    
    if ("MapRecord".equalsIgnoreCase(className)) {
      return new TypeToken<List<MapRecord>>(){}.getType();
    }
    
    if ("PostFcmDeviceRegistrationRequest".equalsIgnoreCase(className)) {
      return new TypeToken<List<PostFcmDeviceRegistrationRequest>>(){}.getType();
    }
    
    if ("PostWnsChannelRegistrationRequest".equalsIgnoreCase(className)) {
      return new TypeToken<List<PostWnsChannelRegistrationRequest>>(){}.getType();
    }
    
    if ("PrivateMessageRecord".equalsIgnoreCase(className)) {
      return new TypeToken<List<PrivateMessageRecord>>(){}.getType();
    }
    
    if ("RegSysAuthenticationRequest".equalsIgnoreCase(className)) {
      return new TypeToken<List<RegSysAuthenticationRequest>>(){}.getType();
    }
    
    if ("SendPrivateMessageRequest".equalsIgnoreCase(className)) {
      return new TypeToken<List<SendPrivateMessageRequest>>(){}.getType();
    }
    
    if ("ToastTest".equalsIgnoreCase(className)) {
      return new TypeToken<List<ToastTest>>(){}.getType();
    }
    
    return new TypeToken<List<Object>>(){}.getType();
  }

  public static Type getTypeForDeserialization(Class cls) {
    String className = cls.getSimpleName();
    
    if ("AggregatedDeltaResponse".equalsIgnoreCase(className)) {
      return new TypeToken<AggregatedDeltaResponse>(){}.getType();
    }
    
    if ("AnnouncementRecord".equalsIgnoreCase(className)) {
      return new TypeToken<AnnouncementRecord>(){}.getType();
    }
    
    if ("AuthenticationResponse".equalsIgnoreCase(className)) {
      return new TypeToken<AuthenticationResponse>(){}.getType();
    }
    
    if ("DealerRecord".equalsIgnoreCase(className)) {
      return new TypeToken<DealerRecord>(){}.getType();
    }
    
    if ("DeltaResponseAnnouncementRecord".equalsIgnoreCase(className)) {
      return new TypeToken<DeltaResponseAnnouncementRecord>(){}.getType();
    }
    
    if ("DeltaResponseDealerRecord".equalsIgnoreCase(className)) {
      return new TypeToken<DeltaResponseDealerRecord>(){}.getType();
    }
    
    if ("DeltaResponseEventConferenceDayRecord".equalsIgnoreCase(className)) {
      return new TypeToken<DeltaResponseEventConferenceDayRecord>(){}.getType();
    }
    
    if ("DeltaResponseEventConferenceRoomRecord".equalsIgnoreCase(className)) {
      return new TypeToken<DeltaResponseEventConferenceRoomRecord>(){}.getType();
    }
    
    if ("DeltaResponseEventConferenceTrackRecord".equalsIgnoreCase(className)) {
      return new TypeToken<DeltaResponseEventConferenceTrackRecord>(){}.getType();
    }
    
    if ("DeltaResponseEventRecord".equalsIgnoreCase(className)) {
      return new TypeToken<DeltaResponseEventRecord>(){}.getType();
    }
    
    if ("DeltaResponseImageRecord".equalsIgnoreCase(className)) {
      return new TypeToken<DeltaResponseImageRecord>(){}.getType();
    }
    
    if ("DeltaResponseKnowledgeEntryRecord".equalsIgnoreCase(className)) {
      return new TypeToken<DeltaResponseKnowledgeEntryRecord>(){}.getType();
    }
    
    if ("DeltaResponseKnowledgeGroupRecord".equalsIgnoreCase(className)) {
      return new TypeToken<DeltaResponseKnowledgeGroupRecord>(){}.getType();
    }
    
    if ("DeltaResponseMapRecord".equalsIgnoreCase(className)) {
      return new TypeToken<DeltaResponseMapRecord>(){}.getType();
    }
    
    if ("EventConferenceDayRecord".equalsIgnoreCase(className)) {
      return new TypeToken<EventConferenceDayRecord>(){}.getType();
    }
    
    if ("EventConferenceRoomRecord".equalsIgnoreCase(className)) {
      return new TypeToken<EventConferenceRoomRecord>(){}.getType();
    }
    
    if ("EventConferenceTrackRecord".equalsIgnoreCase(className)) {
      return new TypeToken<EventConferenceTrackRecord>(){}.getType();
    }
    
    if ("EventFeedbackRecord".equalsIgnoreCase(className)) {
      return new TypeToken<EventFeedbackRecord>(){}.getType();
    }
    
    if ("EventRecord".equalsIgnoreCase(className)) {
      return new TypeToken<EventRecord>(){}.getType();
    }
    
    if ("ImageRecord".equalsIgnoreCase(className)) {
      return new TypeToken<ImageRecord>(){}.getType();
    }
    
    if ("KnowledgeEntryRecord".equalsIgnoreCase(className)) {
      return new TypeToken<KnowledgeEntryRecord>(){}.getType();
    }
    
    if ("KnowledgeGroupRecord".equalsIgnoreCase(className)) {
      return new TypeToken<KnowledgeGroupRecord>(){}.getType();
    }
    
    if ("LinkFragment".equalsIgnoreCase(className)) {
      return new TypeToken<LinkFragment>(){}.getType();
    }
    
    if ("MapEntryRecord".equalsIgnoreCase(className)) {
      return new TypeToken<MapEntryRecord>(){}.getType();
    }
    
    if ("MapRecord".equalsIgnoreCase(className)) {
      return new TypeToken<MapRecord>(){}.getType();
    }
    
    if ("PostFcmDeviceRegistrationRequest".equalsIgnoreCase(className)) {
      return new TypeToken<PostFcmDeviceRegistrationRequest>(){}.getType();
    }
    
    if ("PostWnsChannelRegistrationRequest".equalsIgnoreCase(className)) {
      return new TypeToken<PostWnsChannelRegistrationRequest>(){}.getType();
    }
    
    if ("PrivateMessageRecord".equalsIgnoreCase(className)) {
      return new TypeToken<PrivateMessageRecord>(){}.getType();
    }
    
    if ("RegSysAuthenticationRequest".equalsIgnoreCase(className)) {
      return new TypeToken<RegSysAuthenticationRequest>(){}.getType();
    }
    
    if ("SendPrivateMessageRequest".equalsIgnoreCase(className)) {
      return new TypeToken<SendPrivateMessageRequest>(){}.getType();
    }
    
    if ("ToastTest".equalsIgnoreCase(className)) {
      return new TypeToken<ToastTest>(){}.getType();
    }
    
    return new TypeToken<Object>(){}.getType();
  }

};

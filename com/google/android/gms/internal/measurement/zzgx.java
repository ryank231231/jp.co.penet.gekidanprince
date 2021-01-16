package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.List;
import java.util.Map;

interface zzgx {
  int getTag();
  
  double readDouble() throws IOException;
  
  float readFloat() throws IOException;
  
  String readString() throws IOException;
  
  void readStringList(List<String> paramList) throws IOException;
  
  <T> T zza(zzgy<T> paramzzgy, zzem paramzzem) throws IOException;
  
  <T> void zza(List<T> paramList, zzgy<T> paramzzgy, zzem paramzzem) throws IOException;
  
  <K, V> void zza(Map<K, V> paramMap, zzga<K, V> paramzzga, zzem paramzzem) throws IOException;
  
  @Deprecated
  <T> T zzb(zzgy<T> paramzzgy, zzem paramzzem) throws IOException;
  
  @Deprecated
  <T> void zzb(List<T> paramList, zzgy<T> paramzzgy, zzem paramzzem) throws IOException;
  
  void zzd(List<Double> paramList) throws IOException;
  
  void zze(List<Float> paramList) throws IOException;
  
  void zzf(List<Long> paramList) throws IOException;
  
  void zzg(List<Long> paramList) throws IOException;
  
  void zzh(List<Integer> paramList) throws IOException;
  
  void zzi(List<Long> paramList) throws IOException;
  
  void zzj(List<Integer> paramList) throws IOException;
  
  void zzk(List<Boolean> paramList) throws IOException;
  
  long zzkk() throws IOException;
  
  long zzkl() throws IOException;
  
  int zzkm() throws IOException;
  
  long zzkn() throws IOException;
  
  int zzko() throws IOException;
  
  boolean zzkp() throws IOException;
  
  String zzkq() throws IOException;
  
  zzdp zzkr() throws IOException;
  
  int zzks() throws IOException;
  
  int zzkt() throws IOException;
  
  int zzku() throws IOException;
  
  long zzkv() throws IOException;
  
  int zzkw() throws IOException;
  
  long zzkx() throws IOException;
  
  void zzl(List<String> paramList) throws IOException;
  
  int zzlh() throws IOException;
  
  boolean zzli() throws IOException;
  
  void zzm(List<zzdp> paramList) throws IOException;
  
  void zzn(List<Integer> paramList) throws IOException;
  
  void zzo(List<Integer> paramList) throws IOException;
  
  void zzp(List<Integer> paramList) throws IOException;
  
  void zzq(List<Long> paramList) throws IOException;
  
  void zzr(List<Integer> paramList) throws IOException;
  
  void zzs(List<Long> paramList) throws IOException;
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzgx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
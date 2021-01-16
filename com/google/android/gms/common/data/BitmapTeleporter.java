package com.google.android.gms.common.data;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

@KeepForSdk
@ShowFirstParty
@Class(creator = "BitmapTeleporterCreator")
public class BitmapTeleporter extends AbstractSafeParcelable implements ReflectedParcelable {
  @KeepForSdk
  public static final Parcelable.Creator<BitmapTeleporter> CREATOR = new zaa();
  
  @Field(id = 3)
  private final int mType;
  
  @VersionField(id = 1)
  private final int zale;
  
  @Field(id = 2)
  private ParcelFileDescriptor zalf;
  
  private Bitmap zalg;
  
  private boolean zalh;
  
  private File zali;
  
  @Constructor
  BitmapTeleporter(@Param(id = 1) int paramInt1, @Param(id = 2) ParcelFileDescriptor paramParcelFileDescriptor, @Param(id = 3) int paramInt2) {
    this.zale = paramInt1;
    this.zalf = paramParcelFileDescriptor;
    this.mType = paramInt2;
    this.zalg = null;
    this.zalh = false;
  }
  
  @KeepForSdk
  public BitmapTeleporter(Bitmap paramBitmap) {
    this.zale = 1;
    this.zalf = null;
    this.mType = 0;
    this.zalg = paramBitmap;
    this.zalh = true;
  }
  
  private static void zaa(Closeable paramCloseable) {
    try {
      paramCloseable.close();
      return;
    } catch (IOException iOException) {
      Log.w("BitmapTeleporter", "Could not close stream", iOException);
      return;
    } 
  }
  
  private final FileOutputStream zabz() {
    File file = this.zali;
    if (file != null)
      try {
        file = File.createTempFile("teleporter", ".tmp", file);
        try {
          FileOutputStream fileOutputStream = new FileOutputStream();
          this(file);
          this.zalf = ParcelFileDescriptor.open(file, 268435456);
          file.delete();
          return fileOutputStream;
        } catch (FileNotFoundException fileNotFoundException) {
          throw new IllegalStateException("Temporary file is somehow already deleted");
        } 
      } catch (IOException iOException) {
        throw new IllegalStateException("Could not create temporary file", iOException);
      }  
    throw new IllegalStateException("setTempDir() must be called before writing this object to a parcel");
  }
  
  @KeepForSdk
  public Bitmap get() {
    if (!this.zalh) {
      DataInputStream dataInputStream = new DataInputStream((InputStream)new ParcelFileDescriptor.AutoCloseInputStream(this.zalf));
      try {
        byte[] arrayOfByte = new byte[dataInputStream.readInt()];
        int i = dataInputStream.readInt();
        int j = dataInputStream.readInt();
        Bitmap.Config config = Bitmap.Config.valueOf(dataInputStream.readUTF());
        dataInputStream.read(arrayOfByte);
        zaa(dataInputStream);
        ByteBuffer byteBuffer = ByteBuffer.wrap(arrayOfByte);
        Bitmap bitmap = Bitmap.createBitmap(i, j, config);
        bitmap.copyPixelsFromBuffer(byteBuffer);
        this.zalg = bitmap;
        this.zalh = true;
      } catch (IOException iOException) {
        IllegalStateException illegalStateException = new IllegalStateException();
        this("Could not read from parcel file descriptor", iOException);
        throw illegalStateException;
      } finally {
        Exception exception;
      } 
    } 
    return this.zalg;
  }
  
  @KeepForSdk
  public void release() {
    if (!this.zalh)
      try {
        this.zalf.close();
        return;
      } catch (IOException iOException) {
        Log.w("BitmapTeleporter", "Could not close PFD", iOException);
      }  
  }
  
  @KeepForSdk
  public void setTempDir(File paramFile) {
    if (paramFile != null) {
      this.zali = paramFile;
      return;
    } 
    throw new NullPointerException("Cannot set null temp directory");
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    if (this.zalf == null) {
      Bitmap bitmap = this.zalg;
      ByteBuffer byteBuffer = ByteBuffer.allocate(bitmap.getRowBytes() * bitmap.getHeight());
      bitmap.copyPixelsToBuffer(byteBuffer);
      byte[] arrayOfByte = byteBuffer.array();
      DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(zabz()));
      try {
        dataOutputStream.writeInt(arrayOfByte.length);
        dataOutputStream.writeInt(bitmap.getWidth());
        dataOutputStream.writeInt(bitmap.getHeight());
        dataOutputStream.writeUTF(bitmap.getConfig().toString());
        dataOutputStream.write(arrayOfByte);
        zaa(dataOutputStream);
      } catch (IOException iOException) {
        IllegalStateException illegalStateException = new IllegalStateException();
        this("Could not write into unlinked file", iOException);
        throw illegalStateException;
      } finally {}
    } 
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zale);
    SafeParcelWriter.writeParcelable(paramParcel, 2, (Parcelable)this.zalf, paramInt | 0x1, false);
    SafeParcelWriter.writeInt(paramParcel, 3, this.mType);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
    this.zalf = null;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\data\BitmapTeleporter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
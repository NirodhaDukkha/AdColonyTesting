package com.example.dylan.adcolonytesting.data;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.geo.GeoPoint;
import com.backendless.persistence.BackendlessDataQuery;

public class BackendlessAd
{
  private java.util.Date updated;
  private String adName;
  private String objectId;
  private java.util.Date created;
  private Integer adRating;
  private String ownerId;
  public java.util.Date getUpdated()
  {
    return updated;
  }

  public String getAdName()
  {
    return adName;
  }

  public void setAdName( String adName )
  {
    this.adName = adName;
  }

  public String getObjectId()
  {
    return objectId;
  }

  public java.util.Date getCreated()
  {
    return created;
  }

  public Integer getAdRating()
  {
    return adRating;
  }

  public void setAdRating( Integer adRating )
  {
    this.adRating = adRating;
  }

  public String getOwnerId()
  {
    return ownerId;
  }

                                                    
  public BackendlessAd save()
  {
    return Backendless.Data.of( BackendlessAd.class ).save( this );
  }

  public Future<BackendlessAd> saveAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<BackendlessAd> future = new Future<BackendlessAd>();
      Backendless.Data.of( BackendlessAd.class ).save( this, future );

      return future;
    }
  }

  public void saveAsync( AsyncCallback<BackendlessAd> callback )
  {
    Backendless.Data.of( BackendlessAd.class ).save( this, callback );
  }

  public Long remove()
  {
    return Backendless.Data.of( BackendlessAd.class ).remove( this );
  }

  public Future<Long> removeAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Long> future = new Future<Long>();
      Backendless.Data.of( BackendlessAd.class ).remove( this, future );

      return future;
    }
  }

  public void removeAsync( AsyncCallback<Long> callback )
  {
    Backendless.Data.of( BackendlessAd.class ).remove( this, callback );
  }

  public static BackendlessAd findById( String id )
  {
    return Backendless.Data.of( BackendlessAd.class ).findById( id );
  }

  public static Future<BackendlessAd> findByIdAsync( String id )
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<BackendlessAd> future = new Future<BackendlessAd>();
      Backendless.Data.of( BackendlessAd.class ).findById( id, future );

      return future;
    }
  }

  public static void findByIdAsync( String id, AsyncCallback<BackendlessAd> callback )
  {
    Backendless.Data.of( BackendlessAd.class ).findById( id, callback );
  }

  public static BackendlessAd findFirst()
  {
    return Backendless.Data.of( BackendlessAd.class ).findFirst();
  }

  public static Future<BackendlessAd> findFirstAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<BackendlessAd> future = new Future<BackendlessAd>();
      Backendless.Data.of( BackendlessAd.class ).findFirst( future );

      return future;
    }
  }

  public static void findFirstAsync( AsyncCallback<BackendlessAd> callback )
  {
    Backendless.Data.of( BackendlessAd.class ).findFirst( callback );
  }

  public static BackendlessAd findLast()
  {
    return Backendless.Data.of( BackendlessAd.class ).findLast();
  }

  public static Future<BackendlessAd> findLastAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<BackendlessAd> future = new Future<BackendlessAd>();
      Backendless.Data.of( BackendlessAd.class ).findLast( future );

      return future;
    }
  }

  public static void findLastAsync( AsyncCallback<BackendlessAd> callback )
  {
    Backendless.Data.of( BackendlessAd.class ).findLast( callback );
  }

  public static BackendlessCollection<BackendlessAd> find( BackendlessDataQuery query )
  {
    return Backendless.Data.of( BackendlessAd.class ).find( query );
  }

  public static Future<BackendlessCollection<BackendlessAd>> findAsync( BackendlessDataQuery query )
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<BackendlessCollection<BackendlessAd>> future = new Future<BackendlessCollection<BackendlessAd>>();
      Backendless.Data.of( BackendlessAd.class ).find( query, future );

      return future;
    }
  }

  public static void findAsync( BackendlessDataQuery query, AsyncCallback<BackendlessCollection<BackendlessAd>> callback )
  {
    Backendless.Data.of( BackendlessAd.class ).find( query, callback );
  }
}
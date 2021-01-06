package com.saregama.mvvmmusicapp.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Single


@Dao
interface DeviceDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(device: DeviceEntity): Long

    @Query("SELECT * FROM Device")
    fun get(): Single<DeviceEntity>
}
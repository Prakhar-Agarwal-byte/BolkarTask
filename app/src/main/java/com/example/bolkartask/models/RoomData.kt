package com.example.bolkartask.models

data class RoomData(
    val __v: Int,
    val _id: String,
    val appId: String,
    val blocks: List<Any>,
    val host: Member,
    val members: List<Member>,
    val modHistory: List<String>,
    val moderators: List<Member>,
    val raiseAllow: Boolean,
    val requests: List<Any>,
    val roomid: String,
    val speakers: List<Member>,
    val start_time: String,
    val token: String,
    val topic: String,
    val total_members: Int,
    val type: Int,
    val version: Int,
    val volume: Int
)
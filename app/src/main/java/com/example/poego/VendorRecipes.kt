package com.example.poego

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.poego.databinding.FragmentVendorRecipesBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference


class VendorRecipes : Fragment() {

    private lateinit var sockets6 : ImageView
    private lateinit var linked : ImageView
    private lateinit var gemcutter : ImageView
    private lateinit var chromatic : ImageView
    private lateinit var level20 : ImageView
    private lateinit var magicBoots : ImageView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var vendorBinding = FragmentVendorRecipesBinding.inflate(inflater, container, false)

        var mAuth : FirebaseAuth = FirebaseAuth.getInstance()
            mAuth.signInAnonymously()

        sockets6 = vendorBinding.sockets6
        linked = vendorBinding.socketsLinked
        gemcutter = vendorBinding.gemcutter
        chromatic = vendorBinding.chromatic
        level20  = vendorBinding.level20
        magicBoots  = vendorBinding.magicBoots

        var storage = FirebaseStorage.getInstance()

        var storageRef : StorageReference = storage.reference


        val imageRefChromatic = storageRef.child("images/chromatic.png")
        val imageRefGemcutter = storageRef.child("images/gemcutterprism.jpg")
        val imageRefLevel20gem = storageRef.child("images/level20quality20recipe.jpg")
        val imageRef6linked = storageRef.child("images/linkedsockets6.jpg")
        val imageRefMagicmsboots = storageRef.child("images/magicmsboots.jpg")
        val imageRef6sockets = storageRef.child("images/sockets6.png")

        var MAXBYTES : Long = 1024*1024

        imageRefChromatic.getBytes(MAXBYTES).addOnSuccessListener {
                var bitmap : Bitmap = BitmapFactory.decodeByteArray(it, 0,it.size)
                chromatic.setImageBitmap(bitmap)
        }

        imageRefGemcutter.getBytes(MAXBYTES).addOnSuccessListener {
            var bitmap : Bitmap = BitmapFactory.decodeByteArray(it, 0,it.size)
            gemcutter.setImageBitmap(bitmap)
        }

        imageRefLevel20gem.getBytes(MAXBYTES).addOnSuccessListener {
            var bitmap : Bitmap = BitmapFactory.decodeByteArray(it, 0,it.size)
            level20.setImageBitmap(bitmap)
        }

        imageRef6linked.getBytes(MAXBYTES).addOnSuccessListener {
            var bitmap : Bitmap = BitmapFactory.decodeByteArray(it, 0,it.size)
            linked.setImageBitmap(bitmap)
        }

        imageRefMagicmsboots.getBytes(MAXBYTES).addOnSuccessListener {
            var bitmap : Bitmap = BitmapFactory.decodeByteArray(it, 0,it.size)
            magicBoots.setImageBitmap(bitmap)
        }

        imageRef6sockets.getBytes(MAXBYTES).addOnSuccessListener {
            var bitmap : Bitmap = BitmapFactory.decodeByteArray(it, 0,it.size)
            sockets6.setImageBitmap(bitmap)
        }

        return vendorBinding.root
    }
}
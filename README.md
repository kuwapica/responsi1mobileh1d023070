# RESPONSI 1 MOBILE

Nama       : Annida Aiska Humairoh
NIM        : H1D023070
Shift Baru : D
Shif lama  : I

## Demo Aplikasi


https://github.com/user-attachments/assets/d5177186-40d5-4a93-b8d5-08258dbcf17a 



## Alur Data
API diakses dari https://www.football-data.org/ dengan membuat free account. Untuk menangkap data dari API yaitu menggunakan Postman 
untuk mengecek secara langsung seperti apa respons yang diberikan. 

Kemudian di dalam AndroidManifest.xml menambahkan:
 `<uses-permission android:name="android.permission.INTERNET" />`
 karena aplikasi menggunakan koneksi internet untuk mengambil data dari https://www.football-data.org/

Kemudian membuat direktori utils yang berisi konstanta URL untuk mengakses API-nya. Selanjutnya membuat model dengan nama TeamResponse yang berisi atribut yang diperoleh dari response JSON API.
Setelahnya dibuat RetrofitInstance dan kelas interface FootballApi untuk melakukan pemanggilan ke server API, server merespons dengan data dalam format JSON. Retrofit bersama GSON Converter selanjutnya melakukan parsing, mengubah teks JSON mentah tersebut menjadi objek data class Kotlin sebelum ditampilkan ke user interface.
FootballRepository mengembalikan objek TeamResponse yang sudah jadi kepada MainViewModel. 
MainViewModel menerima objek TeamResponse. Setelah nilainya berubah, LiveData akan memberitahu activity yang sedang berjalan (PlayerActivity maupun HeadCoachActivity).
PlayerActiviy ataupun HeadCoachActivity sekarang memiliki objek TeamResponse. 

<b>PlayerActiviy<b>
Untuk PlayerActivity akan mengambil daftar pemain di dalamnya yaitu squad.
Selain itu pada PlayerActiviy, PlayerAdapter menerima List<Player> yang baru, menyimpannya, dan memanggil notifyDataSetChanged(). Panggilan ini memberitahu RecyclerView bahwa datanya telah berubah dan ia perlu memperbarui tampilannya.
RecyclerView kemudian memanggil onBindViewHolder di adapter untuk setiap pemain dalam daftar baru. Di sinilah data setiap pemain (nama, nationality) diatur ke TextView dan warna kartu diubah berdasarkan posisi. Dan pada player saat diklik, akan menampilkan PlayerDetailFragment pada bagian bawah layar yang berisi data yang diambil dari API yaitu nama, lahir, nationality, dan posisi.

<HeadCoachActivity>
Untuk HeadCoachActivity akan mengambil data coach dengan objek team.coach: mengambil coach.name, coach.dateOfBirth, dan coach.nationality, lalu mengaturnya sebagai teks pada TextView yang sesuai. Maka data yang diambil akan tampil di dalam card yang tampil di activity_head_coach.xml.

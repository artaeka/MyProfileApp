# News Reader App 📰

Tugas Praktikum Minggu 6 - Pengembangan Aplikasi Mobile ITERA

Nama    : Arta Eka Yuly R
NIM     : 123140209
Matkul  : PAM


## API yang Digunakan

**JSONPlaceholder** - https://jsonplaceholder.typicode.com/posts
- Free public REST API
- Tidak memerlukan API key
- Endpoint: `GET /posts` → mengambil list artikel

**Picsum Photos** - https://picsum.photos
- Digunakan untuk generate gambar artikel
- Format: `https://picsum.photos/seed/{id}/400/200`

## Fitur
- Fetch berita dari public API (JSONPlaceholder)
- Tampilan list artikel dengan title, description, dan image
- Detail screen saat artikel di-klik
- Pull to refresh functionality
- Loading, Success, dan Error states
- Repository pattern untuk API calls

## Arsitektur
Model → Repository → ViewModel → UI (Jetpack Compose)

## Tech Stack
- Kotlin
- Jetpack Compose
- Retrofit2
- Coil
- MVVM + Repository Pattern
- Coroutines + StateFlow

## Screenshots

### Loading State
[upload screenshot disini]

### Success State
[upload screenshot disini]

### Detail Screen
[upload screenshot disini]

### Error State
[upload screenshot disini]

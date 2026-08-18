# Cocina JesyAI — Proyecto Android listo para compilar

Este es un proyecto de Android Studio ya armado que envuelve tu app web
`cocina-jesyai_9.html` (La Parrilla del Valle) dentro de un WebView, para
instalarla como app nativa en una tablet de cocina.

Tu archivo real ya está copiado dentro de:
`app/src/main/assets/index.html`

No tuviste que crear ninguna carpeta ni pegar código a mano — todo el
proyecto (manifest, layout, MainActivity, iconos, Gradle) ya está armado.
Solo falta compilarlo. Tienes dos caminos:

---

## OPCIÓN A — Compilar en la nube con GitHub (recomendada, no instalas nada pesado)

Esta opción no requiere instalar Android Studio (que pesa varios GB). El
proyecto ya incluye un workflow de GitHub Actions que compila el APK
automáticamente.

1. Crea una cuenta gratuita en https://github.com si no tienes una.
2. Crea un repositorio nuevo (puede ser privado): botón verde **New**.
3. En la página del repo vacío, usa la opción **"uploading an existing
   file"** y arrastra ahí TODO el contenido de esta carpeta (todos los
   archivos y subcarpetas, incluyendo la carpeta oculta `.github`).
   - Si tu navegador no sube carpetas ocultas al arrastrar, sube primero
     todo lo demás, y luego crea manualmente el archivo
     `.github/workflows/build-apk.yml` pegando el contenido de ese
     archivo (puedes abrirlo con cualquier editor de texto).
4. Haz clic en **Commit changes** para subir los archivos a la rama `main`.
5. Ve a la pestaña **Actions** del repositorio. Verás que el workflow
   "Build APK" empieza a correr solo (tarda 2-4 minutos).
6. Cuando termine (ícono verde ✓), entra a esa ejecución y baja hasta
   **Artifacts**. Ahí vas a poder descargar
   `ComanderoCocina-debug-apk.zip`.
7. Descomprime ese zip: adentro está `app-debug.apk`. Ese es tu instalable.

Si el workflow falla (ícono rojo ✗), abre el log del paso que falló y
copia el error — lo puedes pegar en el chat y te ayudo a corregirlo.

---

## OPCIÓN B — Compilar en tu PC con Android Studio

1. Descarga e instala Android Studio desde https://developer.android.com/studio
2. Abre Android Studio → **Open** (no "New Project") → selecciona esta
   carpeta `ComanderoCocina` completa.
3. Espera a que termine el "Gradle Sync" (barra de progreso abajo). Si
   te pide crear el Gradle Wrapper o usar el Gradle incluido en Android
   Studio, acepta.
4. Ve a **Build → Build Bundle(s) / APK(s) → Build APK(s)**.
5. Cuando termine, aparece un aviso abajo a la derecha:
   "APK(s) generated successfully". Haz clic en **locate** para abrir la
   carpeta donde quedó `app-debug.apk`.

---

## Pasar el APK a la tablet e instalarlo

1. Copia `app-debug.apk` a la tablet (pendrive, Google Drive, Telegram
   o WhatsApp — cualquiera que puedas abrir desde la tablet).
2. En la tablet, abre el archivo `.apk` descargado.
3. Si aparece una advertencia de seguridad, entra a **Ajustes** y activa
   **Permitir desde esta fuente**.
4. Presiona **Instalar** y luego **Abrir**.

## Modo Kiosco (para que los cocineros no puedan salir de la app)

1. En la tablet: **Ajustes → Seguridad → Fijar aplicación** (App Pinning
   / Anclar aplicación) y actívalo.
2. Abre la app "Cocina JesyAI" recién instalada.
3. Toca el botón de **Aplicaciones recientes** (cuadrado o tres líneas).
4. Mantén presionado el ícono de la app y elige **Fijar / Anclar**.

Listo: la tablet queda fija únicamente en la app de cocina, con la
pantalla siempre encendida y conectando en tiempo real con Supabase.

---

## Si actualizas la app de cocina más adelante

Cada vez que cambies tu `index.html` (nuevas funciones, ajustes de
diseño, etc.), solo necesitas:

1. Reemplazar el archivo `app/src/main/assets/index.html` por la nueva
   versión.
2. Volver a compilar (Opción A o B) y reinstalar el APK en la tablet.

No hace falta tocar ningún otro archivo del proyecto.

## Nota de seguridad

Tu `index.html` tiene metida la URL de Supabase y la anon key para leer
y escribir pedidos/menú. Eso ya es así en la versión web y es necesario
para que la app funcione sin login. Solo evita subir este repositorio
de GitHub como **público** si prefieres no exponer esa key — usa
repositorio **privado** (gratis en GitHub) o revisa que tus políticas
RLS en Supabase limiten bien lo que esa key puede hacer.

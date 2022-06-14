FROM nginx:1.11-alpine

# Se agregan metadatos a la imagen
LABEL Descripción="Talento" Autor="Arquitectura" Versión="v1.0.0"

#Variables de entrada
ARG APP_NAME=fps-web-talento
ARG APP_WORKDIR=/var/www/html/$APP_NAME

RUN apk add --no-cache tzdata
ENV TZ=America/Lima
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

#Crear el directorio de trabajo
RUN mkdir -p $APP_WORKDIR

#WORKDIR /
WORKDIR $APP_WORKDIR

RUN rm -r /etc/nginx/nginx.conf && rm -r /etc/nginx/conf.d/default.conf
COPY docker/nginx/nginx.conf /etc/nginx/
COPY docker/nginx/conf.conf /etc/nginx/conf.d/

# Se copian los ficheros hacia la carpeta de nginx
COPY dist/$APP_NAME $APP_WORKDIR

# copiar y ejecutar script
COPY ./setup.sh /root
RUN chmod +x /root/setup.sh
CMD ["/root/setup.sh"]

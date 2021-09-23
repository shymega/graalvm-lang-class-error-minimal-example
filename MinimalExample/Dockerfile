FROM ghcr.io/graalvm/graalvm-ce:latest as builder

WORKDIR /work
ADD . .

RUN gu install native-image

RUN ./mvnw -Pnative-image clean package

FROM debian AS final

COPY .bootstrap.sh /bootstrap.sh
COPY --from=builder /work/target/app /app

ENTRYPOINT ["/bootstrap.sh", "/app"]

CMD ["com.github.shymega.graal.minimalexample.App::handleRequest"]

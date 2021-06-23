export MINIO_ACCESS_KEY=minio
export MINIO_SECRET_KEY=minio123

/data/run/minio server --config-dir /etc/minio \
http://minio{1...2}/data/minio/data{1...2} http://minio{6...7}/data/minio/data{1...2} >> minio-start.log 2>&1 &


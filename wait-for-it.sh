#!/usr/bin/env bash
# wait-for-it.sh

host="$1"
shift
port="$1"
shift

timeout="${WAITFORIT_TIMEOUT:-15}"
strict="${WAITFORIT_STRICT:-false}"

until nc -z "$host" "$port"; do
  echo "Waiting for $host:$port..."
  sleep 1
  timeout=$((timeout - 1))
  if [ "$timeout" -le 0 ]; then
    echo "Timeout waiting for $host:$port"
    if [ "$strict" = "true" ]; then
      exit 1
    else
      break
    fi
  fi
done

exec "$@"

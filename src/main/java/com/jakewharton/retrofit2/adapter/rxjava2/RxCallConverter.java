package com.jakewharton.retrofit2.adapter.rxjava2;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.Response;

public final class RxCallConverter {

    public static <R> Observable<Response<R>> toResponseObservable(Call<R> call) {
        return toCallObservable(call);
    }

    public static <R> Observable<R> toBodyObservable(Call<R> call) {
        return new BodyObservable<>(toCallObservable(call));
    }

    public static <R> Observable<Result<R>> toResultObservable(Call<R> call) {
        return new ResultObservable<>(toCallObservable(call));
    }

    public <R> Observable<Response<R>> responseObservable(Call<R> call) {
        return toCallObservable(call);
    }

    public <R> Observable<R> bodyObservable(Call<R> call) {
        return new BodyObservable<>(toCallObservable(call));
    }

    public <R> Observable<Result<R>> resultObservable(Call<R> call) {
        return new ResultObservable<>(toCallObservable(call));
    }

    private static <R> CallObservable<R> toCallObservable(Call<R> call) {
        return new CallObservable<>(call);
    }

}

//package com.hua.mycoroutine;
//
///**
// * @author zhangsh
// * @version V1.0
// * @date 2020/4/15 11:52 AM
// */
//
//// MyInterceptor.java
//package com.hua.mycoroutine;
//
//import kotlin.Metadata;
//import kotlin.ResultKt;
//import kotlin.Unit;
//import kotlin.coroutines.Continuation;
//import kotlin.coroutines.ContinuationInterceptor;
//import kotlin.coroutines.CoroutineContext;
//import kotlin.coroutines.ContinuationInterceptor.DefaultImpls;
//import kotlin.coroutines.CoroutineContext.Element;
//import kotlin.coroutines.CoroutineContext.Key;
//import kotlin.jvm.functions.Function2;
//import kotlin.jvm.internal.Intrinsics;
//import kotlinx.coroutines.BuildersKt;
//import kotlinx.coroutines.CoroutineScope;
//import kotlinx.coroutines.CoroutineStart;
//import kotlinx.coroutines.DelayKt;
//import kotlinx.coroutines.GlobalScope;
//import kotlinx.coroutines.InternalCoroutinesApi;
//
//import org.jetbrains.annotations.NotNull;
//import org.jetbrains.annotations.Nullable;
//
//@Metadata(
//        mv = {1, 1, 16},
//        bv = {1, 0, 3},
//        k = 1,
//        d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\t0\b\"\u0004\b\u0000\u0010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\bH\u0016R\u0018\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"},
//        d2 = {"Lcom/hua/mycoroutine/MyInterceptor;", "Lkotlin/coroutines/ContinuationInterceptor;", "()V", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "interceptContinuation", "Lkotlin/coroutines/Continuation;", "T", "continuation", "app"}
//)
//public final class MyInterceptor implements ContinuationInterceptor {
//    @NotNull
//    public Key getKey() {
//        return (Key)ContinuationInterceptor.Key;
//    }
//
//    @NotNull
//    public Continuation interceptContinuation(@NotNull Continuation continuation) {
//        Intrinsics.checkParameterIsNotNull(continuation, "continuation");
//        return (Continuation)(new MyContinuation(continuation));
//    }
//
//    public Object fold(Object initial, @NotNull Function2 operation) {
//        Intrinsics.checkParameterIsNotNull(operation, "operation");
//        return DefaultImpls.fold(this, initial, operation);
//    }
//
//    @Nullable
//    public Element get(@NotNull Key key) {
//        Intrinsics.checkParameterIsNotNull(key, "key");
//        return DefaultImpls.get(this, key);
//    }
//
//    @NotNull
//    public CoroutineContext minusKey(@NotNull Key key) {
//        Intrinsics.checkParameterIsNotNull(key, "key");
//        return DefaultImpls.minusKey(this, key);
//    }
//
//    @NotNull
//    public CoroutineContext plus(@NotNull CoroutineContext context) {
//        Intrinsics.checkParameterIsNotNull(context, "context");
//        return DefaultImpls.plus(this, context);
//    }
//
//    public void releaseInterceptedContinuation(@NotNull Continuation continuation) {
//        Intrinsics.checkParameterIsNotNull(continuation, "continuation");
//        DefaultImpls.releaseInterceptedContinuation(this, continuation);
//    }
//}
//// MyContinuation.java
//package com.hua.mycoroutine;
//
//        import kotlin.Metadata;
//        import kotlin.coroutines.Continuation;
//        import kotlin.coroutines.CoroutineContext;
//        import kotlin.jvm.internal.Intrinsics;
//        import org.jetbrains.annotations.NotNull;
//
//@Metadata(
//        mv = {1, 1, 16},
//        bv = {1, 0, 3},
//        k = 1,
//        d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0002\u0010\u0004J\u001e\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0016ø\u0001\u0000¢\u0006\u0002\u0010\u000fR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"},
//        d2 = {"Lcom/hua/mycoroutine/MyContinuation;", "T", "Lkotlin/coroutines/Continuation;", "continuation", "(Lkotlin/coroutines/Continuation;)V", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "getContinuation", "()Lkotlin/coroutines/Continuation;", "resumeWith", "", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "app"}
//)
//public final class MyContinuation implements Continuation {
//    @NotNull
//    private final CoroutineContext context;
//    @NotNull
//    private final Continuation continuation;
//
//    @NotNull
//    public CoroutineContext getContext() {
//        return this.context;
//    }
//
//    public void resumeWith(@NotNull Object result) {
//        String var2 = "拦截协程resume";
//        boolean var3 = false;
//        System.out.println(var2);
//        this.continuation.resumeWith(result);
//    }
//
//    @NotNull
//    public final Continuation getContinuation() {
//        return this.continuation;
//    }
//
//    public MyContinuation(@NotNull Continuation continuation) {
//        Intrinsics.checkParameterIsNotNull(continuation, "continuation");
//        super();
//        this.continuation = continuation;
//        this.context = this.continuation.getContext();
//    }
//}
//// KotlinMainKt.java
//package com.hua.mycoroutine;
//
//        import kotlin.Metadata;
//        import kotlin.ResultKt;
//        import kotlin.Unit;
//        import kotlin.coroutines.Continuation;
//        import kotlin.coroutines.CoroutineContext;
//        import kotlin.coroutines.intrinsics.IntrinsicsKt;
//        import kotlin.jvm.functions.Function2;
//        import kotlin.jvm.internal.Intrinsics;
//        import kotlinx.coroutines.BuildersKt;
//        import kotlinx.coroutines.CoroutineScope;
//        import kotlinx.coroutines.CoroutineStart;
//        import kotlinx.coroutines.DelayKt;
//        import kotlinx.coroutines.GlobalScope;
//        import kotlinx.coroutines.InternalCoroutinesApi;
//        import org.jetbrains.annotations.NotNull;
//        import org.jetbrains.annotations.Nullable;
//
//@Metadata(
//        mv = {1, 1, 16},
//        bv = {1, 0, 3},
//        k = 2,
//        d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0007¨\u0006\u0002"},
//        d2 = {"main", "", "app"}
//)
//public final class KotlinMainKt {
//    @InternalCoroutinesApi
//    public static final void main() {
//        Object o = (new Function2((Continuation)null) {
//            private CoroutineScope p$;
//            Object L$0;
//            int label;
//
//            @Nullable
//            public final Object invokeSuspend(@NotNull Object $result) {
//                Object var5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
//                CoroutineScope $this$launch;
//                String var3;
//                boolean var4;
//                switch(this.label) {
//                    case 0:
//                        ResultKt.throwOnFailure($result);
//                        $this$launch = this.p$;
//                        var3 = "1";
//                        var4 = false;
//                        System.out.println(var3);
//                        this.L$0 = $this$launch;
//                        this.label = 1;
//                        if (DelayKt.delay(100L, this) == var5) {
//                            return var5;
//                        }
//                        break;
//                    case 1:
//                        $this$launch = (CoroutineScope)this.L$0;
//                        ResultKt.throwOnFailure($result);
//                        break;
//                    default:
//                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
//                }
//
//                var3 = "3";
//                var4 = false;
//                System.out.println(var3);
//                return Unit.INSTANCE;
//            }
//
//            @NotNull
//            public final Continuation create(@Nullable Object value, @NotNull Continuation completion) {
//                Intrinsics.checkParameterIsNotNull(completion, "completion");
//                Function2 var3 = new Function2(completion) {
//                    private CoroutineScope p$;
//                    Object L$0;
//                    int label;
//
//                    @Nullable
//                    public final Object invokeSuspend(@NotNull Object $result) {
//                        Object var5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
//                        CoroutineScope $this$launch;
//                        String var3;
//                        boolean var4;
//                        switch(this.label) {
//                            case 0:
//                                ResultKt.throwOnFailure($result);
//                                $this$launch = this.p$;
//                                var3 = "1";
//                                var4 = false;
//                                System.out.println(var3);
//                                this.L$0 = $this$launch;
//                                this.label = 1;
//                                if (DelayKt.delay(100L, this) == var5) {
//                                    return var5;
//                                }
//                                break;
//                            case 1:
//                                $this$launch = (CoroutineScope)this.L$0;
//                                ResultKt.throwOnFailure($result);
//                                break;
//                            default:
//                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
//                        }
//
//                        var3 = "3";
//                        var4 = false;
//                        System.out.println(var3);
//                        return Unit.INSTANCE;
//                    }
//
//                    @NotNull
//                    public final Continuation create(@Nullable Object value, @NotNull Continuation completion) {
//                        Intrinsics.checkParameterIsNotNull(completion, "completion");
//                        Function2 var3 = new Function2(completion) ;
//                        var3.p$ = (CoroutineScope)value;
//                        return var3;
//                        // $FF: Couldn't be decompiled
//                    }
//
//                    public final Object invoke(Object var1, Object var2) {
//                        return ((<undefinedtype>)this.create(var1, (Continuation)var2)).invokeSuspend(Unit.INSTANCE);
//                    }
//                };
//                var3.p$ = (CoroutineScope)value;
//                return var3;
//                // $FF: Couldn't be decompiled
//            }
//
//            public final Object invoke(Object var1, Object var2) {
//                return ((<undefinedtype>)this.create(var1, (Continuation)var2)).invokeSuspend(Unit.INSTANCE);
//            }
//        });
//        BuildersKt.launch$default((CoroutineScope) GlobalScope.INSTANCE, (CoroutineContext)(new MyInterceptor()), (CoroutineStart)null, (Function2)o, 2, (Object)null);
//        Thread.sleep(Long.MAX_VALUE);
//    }
//
//    // $FF: synthetic method
//    public static void main(String[] var0) {
//        main();
//    }
//}
//

//Object var12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
//CoroutineScope $this$launch;
//switch(this.label) {
//case 0:
//ResultKt.throwOnFailure($result);
//$this$launch = this.p$;
//StringBuilder var10000 = (new StringBuilder()).append("1, thread = ");
//Thread var10001 = Thread.currentThread();
//Intrinsics.checkExpressionValueIsNotNull(var10001, "Thread.currentThread()");
//String var13 = var10000.append(var10001.getName()).toString();
//boolean var4 = false;
//System.out.println(var13);
//var4 = false;
//this.L$0 = $this$launch;
//this.L$1 = this;
//this.label = 1;
//boolean var6 = false;
//SafeContinuation var7 = new SafeContinuation(IntrinsicsKt.intercepted(this));
//Continuation it = (Continuation)var7;
//int var9 = false;
//String var10 = "suspend coroutine";
//boolean var11 = false;
//System.out.println(var10);
//Object var14 = var7.getOrThrow();
//if (var14 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
//DebugProbesKt.probeCoroutineSuspended(this);
//}
//
//if (var14 == var12) {
//return var12;
//}
//break;
//case 1:
//<undefinedtype> var3 = (<undefinedtype>)this.L$1;
//$this$launch = (CoroutineScope)this.L$0;
//ResultKt.throwOnFailure($result);
//break;
//default:
//throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
//}
//
//return Unit.INSTANCE;

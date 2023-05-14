create table payment_provider (
  id character varying(36) NOT NULL,
  code character varying(100) NOT NULL,
  name character varying(100) NOT NULL,
  created_at timestamp(6) without time zone,
  created_by character varying(255),
  status_record character varying(255) NOT NULL,
  updated_at timestamp(6) without time zone,
  updated_by character varying(255),
  logo character varying(255),
  constraint payment_provider_pkey primary key (id),
  constraint payment_provider_unique_code unique (code)
);

create table invoice_type (
  id character varying(36) NOT NULL,
  created_at timestamp(6) without time zone,
  created_by character varying(255),
  status_record character varying(255) NOT NULL,
  updated_at timestamp(6) without time zone,
  updated_by character varying(255),
  code character varying(100) NOT NULL,
  name character varying(100) NOT NULL,
  constraint invoice_type_pkey primary key (id)
);

create table invoice_type_provider(
    id_invoice_type character varying(36) NOT NULL,
    id_payment_provider character varying(36) NOT NULL,
    constraint invoice_type_provider_pkey primary key (id_invoice_type, id_payment_provider),
    constraint invoice_type_fkey foreign key (id_invoice_type) references invoice_type,
    constraint payment_provider_fkey foreign key (id_payment_provider) references payment_provider
);

create table invoice (
  id character varying(36) NOT NULL,
  created_at timestamp(6) without time zone,
  created_by character varying(255),
  status_record character varying(255) NOT NULL,
  updated_at timestamp(6) without time zone,
  updated_by character varying(255),
  amount numeric(38,2) NOT NULL,
  description character varying(255) NOT NULL,
  due_date date NOT NULL,
  invoice_number character varying(100) NOT NULL,
  paid boolean NOT NULL,
  id_invoice_type character varying(255) NOT NULL,
  constraint invoice_pkey PRIMARY KEY (id),
  constraint invoice_amount_check CHECK ((amount >= (0)::numeric)),
  constraint invoice_type_fkey foreign key (id_invoice_type) references invoice_type(id)
);

create table virtual_account (
   id character varying(36) NOT NULL,
   created_at timestamp(6) without time zone,
   created_by character varying(255),
   status_record character varying(255) NOT NULL,
   updated_at timestamp(6) without time zone,
   updated_by character varying(255),
   account_number character varying(255) NOT NULL,
   company_id character varying(255) NOT NULL,
   id_invoice character varying(255) NOT NULL,
   id_payment_provider character varying(255) NOT NULL,
   constraint virtual_account_pkey primary key (id),
   constraint invoice_fkey foreign key (id_invoice) references invoice(id),
   constraint payment_provider_fkey foreign key (id_payment_provider) references payment_provider(id)
);

create table payment (
   id character varying(36) NOT NULL,
   created_at timestamp(6) without time zone,
   created_by character varying(255),
   status_record character varying(255) NOT NULL,
   updated_at timestamp(6) without time zone,
   updated_by character varying(255),
   amount numeric(38,2) NOT NULL,
   provider_reference character varying(255) NOT NULL,
   transaction_time timestamp(6) without time zone NOT NULL,
   virtual_account_type character varying(255) NOT NULL,
   id_virtual_account character varying(255) NOT NULL,
   constraint payment_pkey primary key (id),
   constraint payment_amount_check check ((amount >= (1)::numeric)),
   constraint virtual_account_fkey foreign key (id_virtual_account) references virtual_account(id)
);